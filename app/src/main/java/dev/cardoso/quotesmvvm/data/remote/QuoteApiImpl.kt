package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.core.RetrofitHelper
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class QuoteApiImpl @Inject constructor(retrofit: Retrofit):QuoteApi{
    private val apiService: QuoteApi = retrofit.create(QuoteApi::class.java)
    override suspend fun getQuotes(): Response<List<QuoteModel>> {
        return apiService.getQuotes()
    }
}