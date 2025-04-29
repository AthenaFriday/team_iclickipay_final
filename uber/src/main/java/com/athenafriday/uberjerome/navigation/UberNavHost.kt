package com.athenafriday.uberjerome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.uberjerome.screens.CarArrivingScreen
import com.athenafriday.uberjerome.screens.ChoosePaymentScreen
import com.athenafriday.uberjerome.screens.CustomLocationScreen
import com.athenafriday.uberjerome.screens.DelayedTripScreen
import com.athenafriday.uberjerome.screens.EnterLocationScreen
import com.athenafriday.uberjerome.screens.RateDriverScreen
import com.athenafriday.uberjerome.screens.SelectCarScreen
import com.athenafriday.uberjerome.screens.SetDestinationScreen
import com.athenafriday.uberjerome.screens.SetPickupScreen
import com.athenafriday.uberjerome.screens.TripCompleteScreen
import com.athenafriday.uberjerome.screens.TripInProgressScreen

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
