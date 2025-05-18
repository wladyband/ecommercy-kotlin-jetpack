package com.bandeira.ecommerceappmvvm.data.service

import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.model.User


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    // http://10.0.2.2:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>

}