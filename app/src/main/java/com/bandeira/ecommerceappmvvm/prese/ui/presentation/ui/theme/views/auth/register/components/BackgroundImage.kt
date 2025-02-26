package com.bandeira.ecommerceappmvvm.prese.ui.presentation.ui.theme.views.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.bandeira.ecommerceappmvvm.prese.R

@Composable
fun BackgroundImage(){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.rabbit_in_the_office),
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
}