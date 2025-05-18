package com.bandeira.ecommerceappmvvm.domain.useCase.auth

import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository


class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}