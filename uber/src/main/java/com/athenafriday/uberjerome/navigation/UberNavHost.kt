package com.athenafriday.uberjerome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.uberjerome.screens.*

@Composable
fun UberNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = UberDestinations.SetDestination
    ) {
        composable(UberDestinations.SetDestination) { SetDestinationScreen(navController) }
        composable(UberDestinations.SetPickup) { SetPickupScreen(navController) }
        composable(UberDestinations.EnterLocation) { EnterLocationScreen(navController) }
        composable(UberDestinations.SelectCar) { SelectCarScreen(navController) }
        composable(UberDestinations.CarArriving) { CarArrivingScreen(navController) }
        composable(UberDestinations.TripInProgress) { TripInProgressScreen(navController) }
        composable(UberDestinations.TripComplete) { TripCompleteScreen(navController) }
        composable(UberDestinations.RateDriver) { RateDriverScreen(navController) }
        composable(UberDestinations.ChoosePayment) { ChoosePaymentScreen(navController) }
        composable(UberDestinations.DelayedTrip) { DelayedTripScreen(navController) }
        composable(UberDestinations.CustomLocation) { CustomLocationScreen(navController) }
    }
}
