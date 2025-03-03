package com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view.AuthView
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register.RegisterView
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.login.LoginView

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    composable(route = AuthView.Login.route) {
        LoginView(navController)
    }

    composable(route = AuthView.Register.route) {
        RegisterView(navController)
    }
}
