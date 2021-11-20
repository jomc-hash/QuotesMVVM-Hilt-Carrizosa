package dev.cardoso.quotesmvvm.data

import android.util.Log
import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import dev.cardoso.quotesmvvm.data.remote.UserApi
import dev.cardoso.quotesmvvm.data.remote.UserRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import org.json.JSONTokener
import javax.inject.Inject
import kotlin.math.log


class UserRemoteDataSourceImpl @Inject constructor(private val api:UserApi): UserRemoteDataSource {

    override suspend fun loginUser(loginRequest: LoginRequest): Flow<LoginResponse> {
        val response = api.loginUser(loginRequest)
        return (when(response.isSuccessful){
            true-> {
                response.body().let{
                    flow{
                        if(it!= null){
                            Log.e("LOGIN REQUEST", it.toString())
                            emit(it)
                        }
                    }

                }
            }
            else ->{
                val jsonObject = JSONTokener(response.errorBody()?.string()).nextValue() as JSONObject
                val loginResponse = LoginResponse(
                    success = false,
                    message = jsonObject.getString("message"), data = jsonObject.getString("data")
                )
                Log.e("ERROR", loginResponse.toString())
                flow { emit(loginResponse) }
            }
        }
                )
    }
}