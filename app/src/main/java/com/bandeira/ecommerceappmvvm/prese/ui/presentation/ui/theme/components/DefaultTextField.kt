package com.bandeira.ecommerceappmvvm.presentation.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.Red

@Composable
fun DefaultTextField(
    value: String? = "",
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    contentDescription: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier,
    isPasswordField: Boolean? = false,
    ) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(), // Mantém a flexibilidade do Modifier
        value = value ?: "" ,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = contentDescription,
                tint = Red
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType // Aplica o tipo de teclado automaticamente
        ),
        visualTransformation = if (isPasswordField ?: false) PasswordVisualTransformation() else VisualTransformation.None

    )
}
