package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandeira.ecommerceappmvvm.domain.model.AuthResponse
import com.bandeira.ecommerceappmvvm.domain.model.User
import com.bandeira.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.bandeira.ecommerceappmvvm.domain.util.Resource
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var stateRegister by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    var errorMessage by mutableStateOf("")

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (validateFormRegister()) {
            val user = User(
                name = stateRegister.name,
                lastname = stateRegister.lastName,
                phone = stateRegister.phone,
                email = stateRegister.email,
                password = stateRegister.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result // DATA / ERROR
        }
    }



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

    suspend fun validateFormRegister(): Boolean = withContext(Dispatchers.Default) {
        val error = listOf(
            ValidationForm.validateName(stateRegister.name),
            ValidationForm.validateLastName(stateRegister.lastName),
            ValidationForm.validateEmail(stateRegister.email),
            ValidationForm.validatePhone(stateRegister.phone),
            ValidationForm.validatePassword(stateRegister.password),
            ValidationForm.validateConfirmPassword(stateRegister.password, stateRegister.confirmPassword)
        ).filterIsInstance<ValidationResult.Error>()
            .firstOrNull()?.message

        return@withContext if (error != null) {
            errorMessage = error
            false
        } else {
            errorMessage = ""
            true
        }
    }


}
