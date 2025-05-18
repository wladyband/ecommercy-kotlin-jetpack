package com.bandeira.ecommerceappmvvm.data.repository.dataSourceImpl


import com.bandeira.ecommerceappmvvm.data.datastore.AuthDatastore
import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse

import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore): AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}