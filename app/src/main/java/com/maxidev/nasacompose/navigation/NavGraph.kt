package com.maxidev.nasacompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxidev.nasacompose.ui.screen.ApodScreen
import com.maxidev.nasacompose.ui.screen.StartScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Destinations = Destinations.STAR_SCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        composable(route = startDestination.route) {
            StartScreen(
                onNavigation = {
                    navController.navigate(Destinations.APOD_SCREEN.route)
                }
            )
        }
        composable(
            route = Destinations.APOD_SCREEN.route
        ) {
            ApodScreen()
        }
    }
}