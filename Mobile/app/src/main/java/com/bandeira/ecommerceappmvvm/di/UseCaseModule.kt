package com.bandeira.ecommerceappmvvm.di

import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository)
    )

}