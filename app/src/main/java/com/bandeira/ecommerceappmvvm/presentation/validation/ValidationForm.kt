package com.bandeira.ecommerceappmvvm.presentation.validation

object ValidationForm {
    fun validateEmail(email: String): String? {
        return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            "O email não é válido"
        } else {
            null
        }
    }

    fun validatePassword(password: String): String? {
        return if (password.length < 6) {
            "A senha precisa de pelo menos 6 caracteres"
        } else {
            null
        }
    }
}