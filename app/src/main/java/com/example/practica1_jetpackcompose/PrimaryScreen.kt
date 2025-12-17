package com.example.practica1_jetpackcompose

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica1_jetpackcompose.ui.theme.Practica1JetpackComposeTheme

@Composable
fun Greeting() {
    val context = LocalContext.current

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.red)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            Text("Mauricio")
            Text("Victor")
            Text("Salvador")
            Text("Carlos")
            Text("Ivan")
        }

        items(30) { index ->
            Text("Prueba${index + 1}")
        }

        item {
            Image(
                painter = painterResource(R.drawable.imagen_ejercicio),
                contentDescription = "Imagen desierto")
        }

        item {
            Button(onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }) {
                Text("Siguiente Pantalla")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica1JetpackComposeTheme {
        Greeting()
    }
}