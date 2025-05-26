package com.bandeira.ecommerceappmvvm.presentation.ui.theme.views.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.bandeira.ecommerceappmvvm.prese.R
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.navigation.view.AuthView
import com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.login.LoginViewModel
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.DarkGray
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.DefaultButton
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.DefaultTextField

@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()){

    val state = vm.stateLogin
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagem do topo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(
                        0.5f,
                        0.5f,
                        0.5f,
                        1f
                    )
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.cart_shopping),
                contentDescription = "Logo"
            )
            Text(
                text = "Ecommerce",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(
                        alpha = 0.7f
                    )
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(40.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Acessar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        value = state.email,
                        onValueChange = { text -> vm.onEmailInput(text)  },
                        label = "Email",
                        leadingIcon = Icons.Default.Email,
                        contentDescription = "Email icon",
                        keyboardType = KeyboardType.Email,
                        isPasswordField = false,
                        modifier = Modifier.fillMaxWidth()
                    )
                    DefaultTextField(
                        value = state.password,
                        onValueChange = { text -> vm.onPasswordInput(text) },
                        label = "Senha",
                        leadingIcon = Icons.Default.Lock,
                        contentDescription = "Senha icon",
                        keyboardType = KeyboardType.Password,
                        isPasswordField = true, // Ativa a transformação para bolinhas
                        modifier = Modifier.fillMaxWidth()
                    )
                    DefaultButton(
                        text = "Acessar a Conta",
                        onClick = { vm.login() },
                        buttonColor = DarkGray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        buttonPadding = 5.dp // Define um espaçamento externo de 16dp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.clickable {
                                navController.navigate(route = AuthView.Register.route)
                            },
                            text = "Crie sua conta",
                            color = DarkGray
                        )
                    }
                }
            }
        }
    }
}

