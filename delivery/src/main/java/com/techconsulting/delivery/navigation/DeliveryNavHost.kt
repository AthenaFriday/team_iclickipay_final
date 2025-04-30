package com.techconsulting.delivery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techconsulting.delivery.screens.onboarding.WelcomeScreen
import com.techconsulting.delivery.screens.onboarding.ParcelInfoScreen
import com.techconsulting.delivery.screens.map.DeliveryMapScreen

@Composable
fun DeliveryNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DeliveryNavRoutes.WELCOME
    ) {
        composable(DeliveryNavRoutes.WELCOME) {
            WelcomeScreen(onNextClicked = {
                navController.navigate(DeliveryNavRoutes.PARCEL_INFO)
            })
        }

        composable(DeliveryNavRoutes.PARCEL_INFO) {
            ParcelInfoScreen(onNextClicked = {
                navController.navigate(DeliveryNavRoutes.ENTER_ADDRESS)
            })
        }

        composable(DeliveryNavRoutes.ENTER_ADDRESS) {
            DeliveryMapScreen(onNextClicked = {
                // navController.navigate(NextRouteHere)
            })
        }
    }
}


