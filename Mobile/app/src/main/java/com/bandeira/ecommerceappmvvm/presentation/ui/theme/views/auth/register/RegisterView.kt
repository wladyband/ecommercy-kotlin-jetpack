package com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.components.DefaultTopBar
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register.Register
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register.components.RegisterContent
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme

@Composable
fun RegisterView(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )

        },

        ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    EcommerceAppMVVMTheme{
        RegisterView(rememberNavController())
    }
}