package dev.cardoso.quotesmvvm.data

import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.data.remote.QuoteApiImpl
import dev.cardoso.quotesmvvm.data.remote.QuoteRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class QuoteRemoteDataSourceImpl: QuoteRemoteDataSource  {
    override suspend fun getQuotes(): Flow<List<QuoteModel>?> {
        val response =  QuoteApiImpl().getQuotes()
        return (response.body().let {
            flow { emit(it) }
        })
    }
}