package com.bandeira.ecommerceappmvvm.data.repository.dataSourceImpl


import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bandeira.ecommerceappmvvm.data.service.AuthService
import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.model.User


import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}