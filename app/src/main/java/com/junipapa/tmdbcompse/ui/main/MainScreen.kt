package com.junipapa.tmdbcompse.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.junipapa.tmdbcompse.ui.movie.MovieDetail
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
                { movieId ->
                    navController.navigate(route = "${NavScreen.MovieDetail.route}/$movieId")
                }
            )
        }
        composable(
            route = NavScreen.MovieDetail.routeWithArguments,
            arguments = listOf(
                navArgument(NavScreen.MovieDetail.argument0) { type = NavType.LongType }
            )
        ) {
            MovieDetail(
                hiltViewModel()
            )
        }
    }
}
