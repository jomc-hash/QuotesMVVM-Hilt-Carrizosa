package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.Flow

class GetQuoteUseCase(quoteDAO: QuoteDAO) {

    private val quoteRepository = QuoteRepositoryImpl(quoteDAO)

    suspend fun getQuote(quoteId:Int): Flow<QuoteModel> = quoteRepository.getQuote(quoteId)

}