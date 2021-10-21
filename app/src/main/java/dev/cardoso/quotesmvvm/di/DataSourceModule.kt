package dev.cardoso.quotesmvvm.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.QuoteLocalDataSourceImpl
import dev.cardoso.quotesmvvm.data.QuoteRemoteDataSourceImpl
import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.QuoteLocalDataSource
import dev.cardoso.quotesmvvm.data.remote.QuoteApi
import dev.cardoso.quotesmvvm.data.remote.QuoteApiImpl
import dev.cardoso.quotesmvvm.data.remote.QuoteRemoteDataSource
import dev.cardoso.quotesmvvm.domain.QuoteRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindQuoteRepository(
        quoteRepositoryImpl: QuoteRepositoryImpl
    ):QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(
        quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl
    ): QuoteLocalDataSource

    @Binds
    abstract fun bindQuoteRemoteDataSource(
        quoteRemoteDataSourceImpl:QuoteRemoteDataSourceImpl
    ): QuoteRemoteDataSource

    @Binds
    abstract fun bindQuoteApi(
        quoteApiImpl: QuoteApiImpl
    ): QuoteApi

}