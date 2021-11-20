package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import dev.cardoso.quotesmvvm.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository){
    suspend fun loginUser(loginRequest: LoginRequest): Flow<LoginResponse>?
    = userRepository.loginUser(loginRequest)
}