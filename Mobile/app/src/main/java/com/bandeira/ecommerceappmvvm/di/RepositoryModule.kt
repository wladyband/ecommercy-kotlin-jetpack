package com.bandeira.ecommerceappmvvm.ecommerceappmvvm.di


import com.bandeira.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bandeira.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

}