package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.core.API_PATH
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {
    @GET("$API_PATH")
    suspend fun getQuotes(): Response<List<QuoteModel>>
}