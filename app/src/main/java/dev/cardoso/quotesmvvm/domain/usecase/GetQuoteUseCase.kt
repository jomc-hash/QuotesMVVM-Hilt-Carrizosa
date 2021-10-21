package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow

class GetQuoteUseCase(quoteDAO: QuoteDAO, var quoteRepositoryImpl: QuoteRepository) {


    suspend fun getQuote(quoteId:Int): Flow<QuoteModel> = quoteRepositoryImpl.getQuote(quoteId)

}