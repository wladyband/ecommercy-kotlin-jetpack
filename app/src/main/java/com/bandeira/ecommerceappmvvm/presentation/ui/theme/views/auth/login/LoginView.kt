package com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.login.components.LoginContent

@Composable
fun LoginView(navController: NavHostController){
        Scaffold(){
            paddingValues ->
            LoginContent(navController = navController, paddingValues)
        }


}