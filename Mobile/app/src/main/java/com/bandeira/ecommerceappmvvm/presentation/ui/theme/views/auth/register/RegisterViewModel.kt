package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register

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
class RegisterViewModel @Inject constructor() : ViewModel() {

    var stateRegister by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(input: String) {
        stateRegister = stateRegister.copy(name = input)
    }

    fun onLastNameInput(input: String) {
        stateRegister = stateRegister.copy(lastName = input)
    }

    fun onEmailInput(input: String) {
        stateRegister = stateRegister.copy(email = input)
    }

    fun onPhoneInput(input: String) {
        stateRegister = stateRegister.copy(phone = input)
    }

    fun onPasswordInput(input: String) {
        stateRegister = stateRegister.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String) {
        stateRegister = stateRegister.copy(confirmPassword = input)
    }

    fun validateFormRegister() = viewModelScope.launch {
        errorMessage = listOf(
            ValidationForm.validateName(stateRegister.name),
            ValidationForm.validateLastName(stateRegister.lastName),
            ValidationForm.validateEmail(stateRegister.email),
            ValidationForm.validatePhone(stateRegister.phone),
            ValidationForm.validatePassword(stateRegister.password),
            ValidationForm.validateConfirmPassword(stateRegister.password, stateRegister.confirmPassword)
        ).filterIsInstance<ValidationResult.Error>() // Filtra apenas os erros
            .firstOrNull()?.message ?: "" // Pega o primeiro erro encontrado

        delay(3000)
        if (errorMessage.isNotEmpty()) {
            errorMessage = ""
        }
    }

}
