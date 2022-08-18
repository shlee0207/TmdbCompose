package com.junipapa.tmdbcompse.ui.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class NavScreen(val route: String) {
    object Movie : NavScreen("Movie")
    object MovieDetail : NavScreen("MovieDetail") {
        const val routeWithArguments = "MovieDetail/{movieId}"
        const val argument0 = "movieId"
    }
}
