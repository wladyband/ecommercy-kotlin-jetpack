package com.bandeira.ecommerceappmvvm.presentation.validation

import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm.validateEmail
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm.validateLastName
import com.bandeira.ecommerceappmvvm.presentation.validation.ValidationForm.validateName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.runner.RunWith


internal class ValidationFormTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\t", "\n"])
    fun validateName_shouldReturnError_whenNameIsEmpty(name: String?) {
        val result = validateName(
            name!!
        )
        assertTrue(
            result is ValidationResult.Error,
            "Result should be an instance of Error"
        )
        assertEquals(
            "O nome não pode estar vazio",
            (result as ValidationResult.Error).message
        )
    }

    @Test
    fun validateName_shouldReturnSuccess_whenNameIsValid() {
        val result = validateName("Wladimir")
        assertTrue(
            result is ValidationResult.Success,
            "Result should be an instance of Success"
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\t", "\n"])
    fun validateLastName_shouldReturnError_whenLastNameIsEmpty(lastName: String?) {
        val result = validateLastName(
            lastName!!
        )
        assertTrue(result is ValidationResult.Error, "Result should be an instance of Error")
        assertEquals("O sobrenome não pode estar vazio", (result as ValidationResult.Error).message)
    }

    @Test
    fun validateLastName_shouldReturnSuccess_whenLastNameIsValid() {
        val result = validateLastName("Bandeira")
        assertTrue(result is ValidationResult.Success, "Result should be an instance of Success")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   "]) // Inclui espaços em branco e strings vazias
    fun validateEmail_shouldReturnError_whenEmailIsEmptyOrWhitespace(email: String) {
        val result = ValidationForm.validateEmail(email) // Remove o uso de trim()
        assertTrue(result is ValidationResult.Error, "Result should be an instance of Error")
        assertEquals("O email é obrigatório", (result as ValidationResult.Error).message)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "example@example.com",
        "user.name@domain.com",
        "user123@sub.domain.org",
        "email+alias@gmail.com",
        "valid_email@empresa.co",
        "nome.sobrenome@universidade.edu.br"
    ])
    fun validateEmail_shouldReturnSuccess_whenEmailIsValid(email: String) {
        val result = ValidationForm.validateEmail(email)
        assertTrue(result is ValidationResult.Success, "Expected Success, but got: $result")
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "plainaddress",
        "username@.com",
        "username@com",
        "user@domain.c",
        "invalid email@domain.com",
        "user@domain@domain.com",
        "user@domain.toolongtld",
        "user@domain..com"
    ])
    fun validateEmail_shouldReturnError_whenEmailIsInvalid(email: String) {
        val result = ValidationForm.validateEmail(email)
        assertEquals("O email não é válido", (result as ValidationResult.Error).message)
    }

}