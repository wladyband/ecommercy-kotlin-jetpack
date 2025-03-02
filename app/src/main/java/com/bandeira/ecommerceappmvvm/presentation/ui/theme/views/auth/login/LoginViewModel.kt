package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():  ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

}