package com.bandeira.ecommerceappmvvm.data.repository.dataSource


import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>

}