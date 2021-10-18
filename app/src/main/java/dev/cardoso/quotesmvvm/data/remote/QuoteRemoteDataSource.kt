package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRemoteDataSource {
    suspend  fun getQuotes(): Flow<List<QuoteModel>?>
}