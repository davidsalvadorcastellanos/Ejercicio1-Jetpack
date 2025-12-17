package com.example.practica1_jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica1_jetpackcompose.ui.theme.Practica1JetpackComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2() {
    val context = LocalContext.current
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {Text("APP fea")}
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = {
                    val intent = Intent(context, PrimaryActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atras")
                }
                IconButton(onClick = {
                    val intent = Intent(context, ThirdActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.ArrowForwardIos, contentDescription = "Adelante")
                }
            }
        }
    ){
        innerPadding ->
        columna()
    }
}

@Composable
fun columna(){
    val context = LocalContext.current
    LazyRow (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        item {
            Text("Mauricio")
            Text("Victor")
            Text("Salvador")
            Text("Carlos")
            Text("Ivan")
        }

        items(30) { index ->
            Text("Prueba${index + 1}",
                modifier = Modifier.size(100.dp),
                color = colorResource(R.color.red))
        }

        item {
            Image(
                painter = painterResource(R.drawable.imagen_ejercicio),
                contentDescription = "Imagen desierto")
        }

        item {
            Button(onClick = {
                val intent = Intent(context, PrimaryActivity::class.java)
                context.startActivity(intent)
            }) {
                Text("Volver")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Practica1JetpackComposeTheme {
        Greeting2()
    }
}
