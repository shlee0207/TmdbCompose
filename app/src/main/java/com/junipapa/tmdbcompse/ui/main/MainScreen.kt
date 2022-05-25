package com.junipapa.tmdbcompse.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.junipapa.tmdbcompse.ui.navigation.NavScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(
            route = NavScreen.Home.route
        ) {

        }
    }
}
