package com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.login.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bandeira.ecommerceappmvvm.domain.util.Resource
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view.AuthView
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login.LoginViewModel
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.ProgressBar


@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when(val response = vm.loginResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {

            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navController.navigate(route = AuthView.Home.route)
            }

        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}