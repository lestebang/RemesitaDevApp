package com.lesteban.remesitadevapp.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

//val items = listOf(
//    BottomNavigation(
//        title = "Principal",
//        icon = Icons.Rounded.Home
//    ),
//
//    BottomNavigation(
//        title = "Perfil",
//        icon = Icons.Rounded.AccountCircle
//    )
//)

//@Preview
//@Composable
//fun BottomNavigationBar() {
//    NavigationBar {
//        Row(
//            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
//        ) {
//
//            items.forEachIndexed { index, item ->
//                NavigationBarItem(
//                    selected = index == 0,
//                    onClick = {},
//                    icon = {
//                        Icon(
//                            imageVector = item.icon,
//                            contentDescription = item.title,
//                            tint = MaterialTheme.colorScheme.onBackground
//                        )
//                    },
//                    label = {
//                        Text(
//                            text = item.title,
//                            color = MaterialTheme.colorScheme.onBackground
//                        )
//                    }
//                )
//            }
//
//        }
//    }
//}

@Composable
fun BottomNavigationBar(
    navController: NavHostController, state: MutableState<Boolean>, modifier: Modifier = Modifier
) {
    val screens = listOf(
        Destinations.StartScreen, Destinations.Profile
    )

    NavigationBar(
        modifier = modifier.background(MaterialTheme.colorScheme.inverseOnSurface),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->

            NavigationBarItem(
                label = {
                        Text(
                            text = screen.title.toString(),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                icon = {
                    Icon(imageVector = screen.icon!!, contentDescription = screen.title,tint = MaterialTheme.colorScheme.onBackground)
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray, selectedTextColor = Color.White
                ),
            )
        }
    }

}























