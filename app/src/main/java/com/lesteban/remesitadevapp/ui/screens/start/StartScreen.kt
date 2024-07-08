package com.lesteban.remesitadevapp.ui.screens.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lesteban.remesitadevapp.ui.component.CardsSection
import com.lesteban.remesitadevapp.ui.component.TransactionsSection
import com.lesteban.remesitadevapp.ui.component.WalletSection
import com.lesteban.remesitadevapp.utils.PreferencesManager
import com.lesteban.remesitadevapp.utils.networkconnection.ConnectionState
import com.lesteban.remesitadevapp.utils.networkconnection.connectivityState
import kotlinx.coroutines.launch

@Composable
fun StartScreen() {
    val startViewModel = hiltViewModel<StartViewModel>()
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getDataKey("myKey", "")) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(true) {
        if(data.value != ""){
            startViewModel.getBalance(data)
            startViewModel.getCards(data)
        }
//        else{
//            scope.launch {
//                val result = snackbarHostState.showSnackbar(
//                    message = "Snackbar",
//                    actionLabel = "Acción",
//                    duration = SnackbarDuration.Long
//                )
//                when (result) {
//                    SnackbarResult.ActionPerformed -> {
//                        //Si presiono la acción del snackbar
//                    }
//                    SnackbarResult.Dismissed -> {
//                        // Si ignoras el snackbar
//                    }
//                }
//            }
//        }


//        if (isConnected) {
//            scope.launch {
//                val result = snackbarHostState.showSnackbar(
//                    message = "conexcion",
//                    actionLabel = "Acción",
//                    duration = SnackbarDuration.Long
//                )
//                when (result) {
//                    SnackbarResult.ActionPerformed -> {
//                        //Si presiono la acción del snackbar
//                    }
//                    SnackbarResult.Dismissed -> {
//                        // Si ignoras el snackbar
//                    }
//                }
//            }
//        } else {
//            scope.launch {
//                val result = snackbarHostState.showSnackbar(
//                    message = "Sin conexcion",
//                    actionLabel = "Acción",
//                    duration = SnackbarDuration.Long
//                )
//                when (result) {
//                    SnackbarResult.ActionPerformed -> {
//                        //Si presiono la acción del snackbar
//                    }
//                    SnackbarResult.Dismissed -> {
//                        // Si ignoras el snackbar
//                    }
//                }
//            }
//        }
    }





    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        WalletSection(startViewModel)
        CardsSection(startViewModel)
        Spacer(modifier = Modifier.height(16.dp))
        TransactionsSection(startViewModel)
//            CurrenciesSection()
    }
}
