package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RegisterView(navController: NavHostController){
    Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    Text(
                        text = "Cadastro",
                        fontSize = 19.sp
                    )
                },
                Modifier.background(Color.White),
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }
            )
        }
    ) {
         paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = "Registro"
        )
    }
}