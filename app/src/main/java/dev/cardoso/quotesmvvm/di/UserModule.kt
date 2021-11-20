package dev.cardoso.quotesmvvm.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.*
import dev.cardoso.quotesmvvm.data.remote.UserApi
import dev.cardoso.quotesmvvm.data.remote.UserApiImpl
import dev.cardoso.quotesmvvm.data.remote.UserRemoteDataSource
import dev.cardoso.quotesmvvm.domain.UserRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindUserRemoteDataSource(
        userRemoteDataSourceImpl: UserRemoteDataSourceImpl
    ): UserRemoteDataSource

    @Binds
    abstract fun bindUserApi(
        userApiImpl: UserApiImpl
    ): UserApi
}