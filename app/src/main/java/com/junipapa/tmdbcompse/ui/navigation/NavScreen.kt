package com.junipapa.tmdbcompse.ui.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class NavScreen(val route: String) {

    object Home : NavScreen("home")
}
