package com.example.deliverypartnerapp.navigation

import LiveLocationMapScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliverypartnerapp.screens.HomeScreen
import com.example.deliverypartnerapp.screens.LoginScreen
import com.example.deliverypartnerapp.screens.OrderDetailsScreen
import com.example.deliverypartnerapp.utils.LocationTracker

@Composable
fun AppNavigation(navController: NavHostController, locationTracker: LocationTracker) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("order_details") {
            OrderDetailsScreen(navController)
        }
        composable("live_location_map") {
            LiveLocationMapScreen(locationTracker)
        }
    }
}
