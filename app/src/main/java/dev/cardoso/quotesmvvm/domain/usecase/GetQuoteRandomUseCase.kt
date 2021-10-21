package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(quoteDAO: QuoteDAO, var quoteRepositoryImpl: QuoteRepository) {
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepositoryImpl.getQuoteRandom()

}