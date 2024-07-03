package com.lesteban.remesitadevapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.SupervisedUserCircle
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object StartScreen : Destinations(
        route = "start_screen",
        title = "Start",
        icon = Icons.Outlined.Home
    )

    object Profile : Destinations(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Outlined.SupervisedUserCircle
    )
}