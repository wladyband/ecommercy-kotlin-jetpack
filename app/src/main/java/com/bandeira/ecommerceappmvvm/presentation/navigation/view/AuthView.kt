package com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view


sealed class AuthView (val route: String){
    object Login: AuthView("login")
    object Register: AuthView("register")
}
