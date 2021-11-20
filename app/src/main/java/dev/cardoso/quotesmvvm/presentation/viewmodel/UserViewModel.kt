package dev.cardoso.quotesmvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.quotesmvvm.data.model.LoginRequest
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import dev.cardoso.quotesmvvm.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {
    private val loginResponseMutableStateFlow= MutableStateFlow(LoginResponse(false, "", ""))

    val loginResponse: StateFlow<LoginResponse> = loginResponseMutableStateFlow

    fun loginRequest(loginRequest: LoginRequest){
        viewModelScope.launch {
            userUseCase.loginUser(loginRequest)?.collect{
                loginResponseMutableStateFlow.value= it
            }
        }
    }

    fun clearData(){
        loginResponseMutableStateFlow.value = LoginResponse(false, "","")
    }
}