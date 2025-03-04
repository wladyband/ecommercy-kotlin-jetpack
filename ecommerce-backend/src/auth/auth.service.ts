import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from '../users/user.entity';
import { RegisterAuthDto } from './dto/register-auth.dto';

import { Repository } from 'typeorm';

@Injectable()
export class AuthService {
  constructor(
    @InjectRepository(User) private usersRepository: Repository<User>,
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
    return this.usersRepository.save(newUser);
  }
}
