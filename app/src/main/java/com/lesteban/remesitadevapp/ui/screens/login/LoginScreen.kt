package com.lesteban.remesitadevapp.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Autenticacion",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = "Api Key", onValueChange ={} )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = "Api Secret", onValueChange ={} )


    }


}