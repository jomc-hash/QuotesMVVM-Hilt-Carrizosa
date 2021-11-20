package dev.cardoso.quotesmvvm.data

import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import dev.cardoso.quotesmvvm.data.remote.UserRemoteDataSource
import dev.cardoso.quotesmvvm.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(var userRemoteDataSource: UserRemoteDataSource):UserRepository {

    override suspend fun loginUser(loginRequest: LoginRequest): Flow<LoginResponse>? {
        return userRemoteDataSource.loginUser(loginRequest)
    }

}