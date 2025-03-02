package com.bandeira.ecommerceappmvvm.presentation.validation

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}
