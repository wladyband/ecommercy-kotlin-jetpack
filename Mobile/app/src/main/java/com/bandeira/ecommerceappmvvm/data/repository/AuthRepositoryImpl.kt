package com.bandeira.ecommerceappmvvm.data.repository


import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.model.User
import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository
import com.bandeira.ecommerceappmvvm.domain.util.Resource
import com.bandeira.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow


class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}