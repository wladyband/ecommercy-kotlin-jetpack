package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bandeira.ecommerceappmvvm.prese.R
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.DefaultButton
import com.bandeira.ecommerceappmvvm.presentation.ui.theme.components.DefaultTextField


@Composable
fun RegisterContent(paddingValues: PaddingValues) {

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ){
    BackgroundImage()
    HeaderBanner()
    Column(
           modifier = Modifier.padding(30.dp)
       ) {
           Spacer(modifier = Modifier.weight(1f))
           Card(
                 modifier = Modifier
                     .fillMaxWidth(),
                 shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
                 colors = CardDefaults.cardColors(
                     containerColor = Color.White.copy(
                         alpha = 0.7f
                     )
                 )
             ) {
                 Column(
                     modifier = Modifier.padding(40.dp)
                 ) {
                     Text(
                         modifier = Modifier.padding(bottom = 20.dp),
                         text = "Cadastrar",
                         fontWeight = FontWeight.Bold,
                         fontSize = 20.sp,
                         color = Color.Black
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Nome",
                         leadingIcon = Icons.Default.Person,
                         contentDescription = "Nome icon",
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Apelido",
                         leadingIcon = Icons.Default.Person,
                         contentDescription = "Apelido icon",
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Email Pessoal",
                         leadingIcon = Icons.Default.Email,
                         contentDescription = "Email person",
                         isPasswordField = false,
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Celular",
                         leadingIcon = Icons.Default.Call,
                         contentDescription = "Call person",
                         isPasswordField = false,
                         keyboardType = KeyboardType.Number,
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Senha",
                         leadingIcon = Icons.Default.Lock,
                         contentDescription = "Email person",
                         isPasswordField = false,
                         keyboardType = KeyboardType.Password,
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultTextField(
                         onValueChange = {  },
                         label = "Confirmação da Senha",
                         leadingIcon = Icons.Default.Lock,
                         contentDescription = "Senha person",
                         isPasswordField = false,
                         keyboardType = KeyboardType.Password,
                         modifier = Modifier.fillMaxWidth()
                     )
                     DefaultButton(
                         modifier = Modifier
                             .fillMaxWidth()
                             .height(50.dp)
                             .padding(top = 5.dp),
                         text = "Confirmar",
                         onClick = { /*TODO*/ }
                     )
                 }
             }
         }

    }
}

