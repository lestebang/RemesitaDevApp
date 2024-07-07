package com.lesteban.remesitadevapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.SupervisedUserCircle
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object StartScreen : Destinations(
        route = "start_screen",
        title = "Inicio",
        icon = Icons.Outlined.Home
    )

    object Profile : Destinations(
        route = "profile_screen",
        title = "Perfil",
        icon = Icons.Outlined.SupervisedUserCircle
    )

    object Login : Destinations(
        route = "login_screen",
        title = "Autenticación",
        icon = Icons.Outlined.Login
    )
}