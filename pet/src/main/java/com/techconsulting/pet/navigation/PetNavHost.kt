package com.techconsulting.pet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techconsulting.pet.screens.onboarding.*

@Composable
fun PetNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.WELCOME
        // TODO: Add screen transition animations using AnimatedNavHost / Accompanist Navigation later
    ) {
        composable(NavRoutes.WELCOME) {
            WelcomeScreen(onNextClicked = {
                navController.navigate(NavRoutes.PET_INFO)
            })
        }

        composable(NavRoutes.PET_INFO) {
            PetInfoScreen(onNextClicked = {
                navController.navigate(NavRoutes.TAKE_PHOTO)
            })
        }

        composable(NavRoutes.TAKE_PHOTO) {
            TakePhotoScreen(
                onBackClicked = { navController.popBackStack() },
                onTakePhotoClicked = { navController.navigate(NavRoutes.PET_LIST) }
            )
        }

        composable(NavRoutes.PET_LIST) {
            YourDogListScreen(
                onAddNewClicked = { navController.navigate(NavRoutes.PET_INFO) },
                onNextClicked = { /* TODO: go to booking screens */ }
            )
        }
    }
}
