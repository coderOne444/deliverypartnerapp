package com.example.deliverypartnerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.deliverypartnerapp.navigation.AppNavigation
import com.example.deliverypartnerapp.ui.theme.DeliveryPartnerAppTheme
import com.example.deliverypartnerapp.utils.LocationTracker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize LocationTracker
        val locationTracker = LocationTracker(this)

        setContent {
            DeliveryPartnerAppTheme {
                // Set up the navigation controller
                val navController: NavHostController = rememberNavController()

                // Pass LocationTracker to the AppNavigation composable
                AppNavigation(navController = navController, locationTracker = locationTracker)
            }
        }
    }
}
