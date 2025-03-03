package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():  ViewModel() {

    var stateLogin by mutableStateOf(LoginState())
        private set

    var errorMessage  by mutableStateOf("")
        private set

    fun onEmailInput(input: String){
        stateLogin = stateLogin.copy(email = input)
    }

    fun onPasswordInput(input: String){
        stateLogin = stateLogin.copy(password = input)
    }

    fun validateFormLogin() = viewModelScope.launch {
        errorMessage = listOf(
            ValidationForm.validateEmail(stateLogin.email),
            ValidationForm.validatePassword(stateLogin.password)
        ).filterIsInstance<ValidationResult.Error>() // Filtra apenas os erros
            .firstOrNull()?.message ?: "" // Pega o primeiro erro encontrado

        delay(3000)
        if (errorMessage.isNotEmpty()) {
            errorMessage = ""
        }
    }


}