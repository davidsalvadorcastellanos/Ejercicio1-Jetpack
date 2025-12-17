package com.example.practica1_jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica1_jetpackcompose.ui.theme.Practica1JetpackComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting3() {
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
                    val intent = Intent(context, SecondActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atras")
                }
                IconButton(onClick = {
                    val intent = Intent(context, PrimaryActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.ArrowForwardIos, contentDescription = "Adelante")
                }
            }
        }
    ){
        innerPadding ->
        MusicPlayerScreen()
    }
}

@Composable
fun MusicPlayerScreen() {
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.videoplayback)
    }

    // Guarda si reproduce
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Reproductor de Música", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            IconButton(onClick = {
                if (!isPlaying) {
                    mediaPlayer.start()
                    isPlaying = true
                }
            }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_media_play),
                    contentDescription = "Play",
                    modifier = Modifier.size(64.dp)
                )
            }

            IconButton(onClick = {
                if (isPlaying) {
                    mediaPlayer.pause()
                    isPlaying = false
                }
            }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_media_pause),
                    contentDescription = "Pause",
                    modifier = Modifier.size(64.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Practica1JetpackComposeTheme {
        Greeting3()
    }
}