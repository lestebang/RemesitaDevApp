package com.lesteban.remesitadevapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lesteban.remesitadevapp.ui.screens.login.LoginScreen
import com.lesteban.remesitadevapp.ui.screens.profile.ProfileScreen
import com.lesteban.remesitadevapp.ui.screens.start.StartScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.StartScreen.route) {
        composable(Destinations.StartScreen.route) {
            StartScreen()
        }
        composable(Destinations.Profile.route) {
            ProfileScreen()
        }
        composable(Destinations.Login.route) {
            LoginScreen(navController)
        }
    }
}