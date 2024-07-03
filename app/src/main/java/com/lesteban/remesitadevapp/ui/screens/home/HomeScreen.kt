package com.lesteban.remesitadevapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.navigation.BottomNavigationBar
import com.lesteban.remesitadevapp.navigation.Destinations
import com.lesteban.remesitadevapp.navigation.NavigationGraph
import com.lesteban.remesitadevapp.ui.component.CardsSection
import com.lesteban.remesitadevapp.ui.component.WalletSection
import com.lesteban.remesitadevapp.ui.screens.profile.ProfileScreen
import com.lesteban.remesitadevapp.ui.screens.start.StartScreen
import com.lesteban.remesitadevapp.utils.network.DataState

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    LaunchedEffect(true) {
        homeViewModel.auth()
    }

    if (homeViewModel.authM.value is DataState.Success<AuthModel>) {
        homeViewModel.insertUser((homeViewModel.authM.value as DataState.Success<AuthModel>).data)
    }


    val navController: NavHostController = rememberNavController()

    var buttonsVisible = remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController,
                state = buttonsVisible,
                modifier = Modifier)
        }
    ) { padding ->
        Box(
            modifier = Modifier.padding(padding)
        ) {
            NavigationGraph(navController = navController)
        }
    }
}


