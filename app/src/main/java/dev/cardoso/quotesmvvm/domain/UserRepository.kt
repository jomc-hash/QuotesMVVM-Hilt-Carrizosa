package dev.cardoso.quotesmvvm.domain

import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Flow<LoginResponse>?
}