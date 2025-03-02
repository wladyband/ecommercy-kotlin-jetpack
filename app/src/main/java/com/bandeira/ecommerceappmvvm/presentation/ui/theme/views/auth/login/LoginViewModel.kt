package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():  ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage  by mutableStateOf("")
        private set

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

 /*   fun validateFormLogin() = viewModelScope.launch{
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "O email não é valido"
        } else if(state.password.length < 6){
            errorMessage = "A senha precisa de pelo menos 6 caracteres"
        }

        delay(3000)
        errorMessage = ""
    }*/

    fun validateFormLogin() = viewModelScope.launch {
        errorMessage = ValidationForm.validateEmail(state.email)
            ?: ValidationForm.validatePassword(state.password) ?: ""
        delay(3000)
        if (errorMessage.isNotEmpty()) {
            errorMessage = ""
        }
    }

}