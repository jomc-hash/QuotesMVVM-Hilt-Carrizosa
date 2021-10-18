package dev.cardoso.quotesmvvm.data

import android.accounts.NetworkErrorException
import android.util.Log
import dev.cardoso.quotesmvvm.core.convertToList
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.flow.*


class QuoteRepositoryImpl(quoteDAO: QuoteDAO): QuoteRepository {
    private val localDataSource= QuoteLocalDataSourceImpl(quoteDAO)
    private val remoteDataSource= QuoteRemoteDataSourceImpl()

    override suspend  fun getQuotes(): Flow<List<QuoteModel>> {
        val remoteQuotes =
        try {
            remoteDataSource.getQuotes()
        } catch (ex: Exception) {
            when (ex) {
                is NetworkErrorException -> throw ex
                else -> null
            }
        }
        val quotes = ArrayList<QuoteModel>()
        if (remoteQuotes != null) {
            remoteQuotes.collect {
                it?.forEach { quoteModel->
                    quotes.add(quoteModel)
                }
            }
            localDataSource.insertAll(quotes)
        }
        return (flow { emit (quotes) })
    }

    override suspend fun getQuoteRandom(): Flow<QuoteModel> {
        return  localDataSource.getQuoteRandom()
    }

    override suspend fun getQuote(quoteId: Int): Flow<QuoteModel> {
           return localDataSource.getQuote(quoteId)
    }
}