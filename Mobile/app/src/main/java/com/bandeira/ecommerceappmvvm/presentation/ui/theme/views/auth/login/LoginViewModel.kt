package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.bandeira.ecommerceappmvvm.domain.util.Resource
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase):  ViewModel() {

    var stateLogin by mutableStateOf(LoginState())
        private set

    var errorMessage  by mutableStateOf("")

    // LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        try {
            if (validateFormLogin()) {
                loginResponse = Resource.Loading // Em andamento
                val result = authUseCase.login(stateLogin.email, stateLogin.password)
                loginResponse = result
                Log.d("LoginViewModel", "Response: $loginResponse")
            }
        } catch (e: Exception) {
            // Captura qualquer erro inesperado
            loginResponse = Resource.Failure("Erro inesperado: ${e.localizedMessage ?: "Erro desconhecido"}")
            Log.e("LoginViewModel", "Erro no login", e)
        }
    }


    fun onEmailInput(input: String){
        stateLogin = stateLogin.copy(email = input)
    }

    fun onPasswordInput(input: String){
        stateLogin = stateLogin.copy(password = input)
    }

    suspend fun validateFormLogin(): Boolean {
        val error = listOf(
            ValidationForm.validateEmail(stateLogin.email),
            ValidationForm.validatePassword(stateLogin.password)
        ).filterIsInstance<ValidationResult.Error>()
            .firstOrNull()?.message

        return if (error != null) {
            errorMessage = error
            delay(3000)
            errorMessage = ""
            false
        } else {
            true
        }
    }



}