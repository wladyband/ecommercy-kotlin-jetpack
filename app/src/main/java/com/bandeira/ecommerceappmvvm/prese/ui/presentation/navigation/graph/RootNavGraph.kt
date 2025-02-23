package com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view.AuthView
import com.bandeira.ecommerceappmvvm.presentation.navigation.Graph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        // Definição do subgrafo de autenticação
        navigation(startDestination = AuthView.Login.route, route = Graph.AUTH) {
            AuthNavGraph(navController = navController)
        }
    }
}
