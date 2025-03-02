package com.bandeira.ecommerceappmvvm.presentation.validation

object ValidationForm {

    fun validateName(name: String): ValidationResult {
        return if (name.isBlank()) ValidationResult.Error("O nome não pode estar vazio")
        else ValidationResult.Success
    }

    fun validateLastName(lastName: String): ValidationResult {
        return if (lastName.isBlank()) ValidationResult.Error("O sobrenome não pode estar vazio")
        else ValidationResult.Success
    }

    fun validateEmail(email: String): ValidationResult {
        return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
            ValidationResult.Error("O email não é válido")
        else ValidationResult.Success
    }

    fun validatePhone(phone: String): ValidationResult {
        return if (phone.length < 10) ValidationResult.Error("O número de telefone deve ter pelo menos 10 dígitos")
        else ValidationResult.Success
    }

    fun validatePassword(password: String): ValidationResult {
        return if (password.length < 6) ValidationResult.Error("A senha precisa de pelo menos 6 caracteres")
        else ValidationResult.Success
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): ValidationResult {
        return if (password != confirmPassword) ValidationResult.Error("As senhas não coincidem")
        else ValidationResult.Success
    }
}
