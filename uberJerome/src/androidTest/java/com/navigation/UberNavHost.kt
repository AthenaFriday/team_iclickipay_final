package com.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.screens.CarArrivingScreen
import com.screens.ChoosePaymentScreen
import com.screens.CustomLocationScreen
import com.screens.DelayedTripScreen
import com.screens.EnterLocationScreen
import com.screens.RateDriverScreen
import com.screens.SelectCarScreen
import com.screens.SetDestinationScreen
import com.screens.SetPickupScreen
import com.screens.TripCompleteScreen
import com.screens.TripInProgressScreen

@Composable
fun UberNavHost(navController: NavHostController) {
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
