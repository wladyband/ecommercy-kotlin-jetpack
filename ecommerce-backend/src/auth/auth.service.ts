import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from '../users/user.entity';
import { RegisterAuthDto } from './dto/register-auth.dto';

import { In, Repository } from 'typeorm';
import { compare } from 'bcryptjs';
import { LoginAuthDto } from './dto/login-auth.dto';
import { JwtService } from '@nestjs/jwt';
import { Rol } from 'src/roles/rol.entity';

@Injectable()
export class AuthService {
  constructor(
    @InjectRepository(User) private usersRepository: Repository<User>,
    @InjectRepository(Rol) private rolesRepository: Repository<Rol>,
    private jwtService: JwtService,
  ) {}

  async register(user: RegisterAuthDto) {
    const { email, phone } = user;
    const emailExist = await this.usersRepository.findOneBy({ email: email });

    if (emailExist) {
      // 409 CONFLICT
      throw new HttpException(
        'Esse email já está cadastrado',
        HttpStatus.CONFLICT,
      );
    }

    const phoneExist = await this.usersRepository.findOneBy({ phone: phone });

    if (phoneExist) {
      throw new HttpException(
        'Esse contato telefonico já está registrado',
        HttpStatus.CONFLICT,
      );
    }

    const newUser = this.usersRepository.create(user);
    // in roles
    // DATA
    const rolesIds = user.rolesIds;

    const roles = await this.rolesRepository.findBy({ id: In(rolesIds) });
    newUser.roles = roles;

    const userSaved = await this.usersRepository.save(newUser);

    const payload = {
      id: userSaved.id,
      name: userSaved.name,
    };
    const token = this.jwtService.sign(payload);
    const data = {
      user: userSaved,
      token: 'Bearer ' + token,
    };
    delete data.user.password;
    return data;
  }
  async login(loginData: LoginAuthDto) {
    const { email, password } = loginData;
    const userFound = await this.usersRepository.findOne({
      where: { email: email },
      relations: ['roles'],
    });
    if (!userFound) {
      throw new HttpException('Email não existe', HttpStatus.NOT_FOUND);
    }

    const isPasswordValid = await compare(password, userFound.password);
    if (!isPasswordValid) {
      // 403 FORBITTEN access denied
      throw new HttpException('A senha está incorreta', HttpStatus.FORBIDDEN);
    }
    const rolesIds = userFound.roles.map((rol) => rol.id); //['CLIENT', 'ADMIN']

    const payload = {
      id: userFound.id,
      name: userFound.name,
      roles: rolesIds,
    };
    const token = this.jwtService.sign(payload);
    const data = {
      user: userFound,
      token: 'Bearer ' + token,
    };

    delete data.user.password;

    return data;
  }
}
