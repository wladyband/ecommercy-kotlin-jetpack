package com.bandeira.ecommerceappmvvm.domain.useCase.auth

import com.bandeira.ecommerceappmvvm.domain.model.User
import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository


class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) =  repository.register(user);

}