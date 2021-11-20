package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun loginUser(loginRequest: LoginRequest): Flow<LoginResponse>
}