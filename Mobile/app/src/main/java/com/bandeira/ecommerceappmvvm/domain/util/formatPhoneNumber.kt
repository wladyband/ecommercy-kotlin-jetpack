package com.bandeira.ecommerceappmvvm.domain.util

fun formatPhoneNumber(input: String): String {
    val digits = input.filter { it.isDigit() }.take(11) // Só os dígitos

    return when (digits.length) {
        in 0..2 -> "(${digits}"
        in 3..6 -> "(${digits.substring(0, 2)}) ${digits.substring(2)}"
        in 7..10 -> "(${digits.substring(0, 2)}) ${digits.substring(2, 6)}-${digits.substring(6)}"
        11 -> "(${digits.substring(0, 2)}) ${digits.substring(2, 7)}-${digits.substring(7)}"
        else -> digits
    }
}
