package com.bandeira.ecommerceappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bandeira.ecommerceappmvvm.ui.theme.EcommerceAppMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceAppMVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LoginContent()
                }
            }
        }
    }
}


@Composable
fun LoginContent(){
    Box(modifier = Modifier.fillMaxSize()){
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
                painter = painterResource(id = R.drawable.shopping_cart_blue),
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
                colors = CardDefaults.cardColors(Color.White)

            ) {
                 Column(
                     modifier = Modifier.padding(40.dp)
                 ) {
                     Text(
                         modifier = Modifier.padding(bottom = 20.dp),
                         text = "Acessar",
                         fontWeight = FontWeight.Bold,
                         fontSize = 20.sp,
                         color = Color.Black
                     )
                     TextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = "",
                         onValueChange = {},
                         label = {
                             Text(text = "Email")
                         }
                     )
                     TextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = "",
                         onValueChange = {},
                         label = {
                             Text(text = "Senha")
                         }
                     )
                     Button(
                         modifier = Modifier.fillMaxWidth(),
                         onClick = {
                         /*TODO*/
                         }
                     ) {
                         Text(text = "Login")
                     }
                     Row(
                         modifier = Modifier.fillMaxWidth(),
                         horizontalArrangement = Arrangement.Center
                     ) {
                         Text(text = "Não possuo conta")
                         Text(
                             text = "Crie sua conta",
                             color = Color.Blue
                         )
                     }
                 }
            }
        }
    }
}

