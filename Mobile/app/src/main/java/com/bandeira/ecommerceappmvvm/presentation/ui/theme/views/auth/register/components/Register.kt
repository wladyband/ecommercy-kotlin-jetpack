package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bandeira.ecommerceappmvvm.domain.util.Resource
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view.AuthView
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.ProgressBar

@Composable
fun Register(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {

    when(val response = vm.registerResponse) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navController.navigate(route = AuthView.Home.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}