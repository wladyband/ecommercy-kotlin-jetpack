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
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.components.DefaultTopBar

@Composable
fun RegisterView(navController: NavHostController){
    Scaffold(
            topBar = {
              DefaultTopBar(
                  upAvailable = true,
                  title = "Cadastro",
                  navController = navController
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