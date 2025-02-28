package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():  ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

}