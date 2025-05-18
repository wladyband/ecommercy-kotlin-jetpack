package com.bandeira.ecommerceappmvvm.domain.useCase.auth

import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}