package com.bandeira.ecommerceappmvvm.domain.useCase.auth

import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository


class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}