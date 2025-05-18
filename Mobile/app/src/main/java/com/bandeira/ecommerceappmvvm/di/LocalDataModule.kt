package com.bandeira.ecommerceappmvvm.ecommerceappmvvm.di


import com.bandeira.ecommerceappmvvm.data.datastore.AuthDatastore
import com.bandeira.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bandeira.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

}