package com.lesteban.remesitadevapp.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.utils.PreferencesManager
import com.lesteban.remesitadevapp.utils.network.DataState

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {
    val loginViewModel = hiltViewModel <LoginViewModel>()
    var api by rememberSaveable { mutableStateOf("") }
    var secret by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getDataKey("myKey", "")) }


    if (loginViewModel.authM.value is DataState.Success<AuthModel>) {
        loginViewModel.insertUser((loginViewModel.authM.value as DataState.Success<AuthModel>).data)
        val key = (loginViewModel.authM.value as DataState.Success<AuthModel>).data.accessToken
        preferencesManager.saveDataKey("myKey", key)
        data.value = key
        loginViewModel.authM.value = null
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Autenticacion",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(value = api, onValueChange ={api = it} ,  placeholder = { Text("Api Key") })
        Spacer(modifier = Modifier.height(8.dp))

        TextField(value = secret, onValueChange ={secret = it} ,  placeholder = { Text("Api Secret") })
        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            modifier = Modifier.background(Color.White).align(Alignment.CenterHorizontally),
            onClick = {
                loginViewModel.auth(api,secret)
            }) {
            Text(
                "Autenticar",
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = Color.Black)
            )
        }
    }
}