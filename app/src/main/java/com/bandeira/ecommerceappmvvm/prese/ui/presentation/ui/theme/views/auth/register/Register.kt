package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterView(){
    Scaffold() {
        paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = "Registro"
        )
    }
}