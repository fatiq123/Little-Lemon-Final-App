package com.example.littlelemonfinalapp

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DestinationImp.home) {
        // Define navigation routes for each destination
        composable(DestinationImp.home) {
            // Composable for the "Home" destination
            // Replace this with your actual Home screen content
        }
        composable(DestinationImp.profile) {
            // Composable for the "Onboarding" destination
            // Replace this with your actual Onboarding screen content
        }
        // Add more composable entries for other destinations as needed
    }
}
