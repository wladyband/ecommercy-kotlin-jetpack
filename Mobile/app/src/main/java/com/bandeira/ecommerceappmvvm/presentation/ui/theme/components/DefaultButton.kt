package com.bandeira.ecommerceappmvvm.presentation.ui.theme.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = ButtonDefaults.buttonColors().containerColor, // Cor opcional
    buttonPadding: Dp = 0.dp // Espaçamento externo opcional
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(buttonPadding), // Aplica o espaçamento externo personalizado
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor), // Aplica a cor personalizada
    ) {
        Text(text = text)
    }
}

