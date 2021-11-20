package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.core.LOGIN_URL
import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {
    @Headers("Content-Type: application/json; charset=utf-8", "Accept: */*; charset=utf-8")
    @POST("$LOGIN_URL")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>


}