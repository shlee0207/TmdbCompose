package com.junipapa.tmdbcompse.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.junipapa.tmdbcompse.ui.movie.MovieScreen
import com.junipapa.tmdbcompse.ui.navigation.NavScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Movie.route) {
        composable(
            route = NavScreen.Movie.route
        ) {
            MovieScreen(
                hiltViewModel(),
                {}
            )
        }
    }
}
