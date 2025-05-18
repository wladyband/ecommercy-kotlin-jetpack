package com.bandeira.ecommerceappmvvm.domain.repository

import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.model.User
import com.bandeira.ecommerceappmvvm.domain.util.Resource

import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String):  Resource<AuthResponse>
    suspend fun register(user: User):  Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>
}