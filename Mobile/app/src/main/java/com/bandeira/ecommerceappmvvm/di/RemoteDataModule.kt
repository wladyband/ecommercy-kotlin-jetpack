package com.bandeira.ecommerceappmvvm.di

import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bandeira.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.bandeira.ecommerceappmvvm.data.service.AuthService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

}