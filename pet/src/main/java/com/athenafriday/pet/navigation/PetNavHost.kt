package com.athenafriday.pet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.pet.screens.onboarding.*

@Composable
fun PetNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.WELCOME
    ) {
        composable(NavRoutes.WELCOME) {
            WelcomeScreen(onNextClicked = {
                navController.navigate(NavRoutes.PET_INFO)
            })
        }

        composable(NavRoutes.PET_INFO) {
            PetInfoScreen(onNextClicked = {
                navController.navigate(NavRoutes.UPLOAD_PHOTO)
            })
        }

        composable(NavRoutes.UPLOAD_PHOTO) {
            UploadPhotoScreen(
                onBackClicked = { navController.popBackStack() },
                onTakePhotoClicked = {
                    navController.navigate(NavRoutes.PET_LIST)
                }
            )
        }

        composable(NavRoutes.PET_LIST) {
            YourDogListScreen(
                onAddNewClicked = {
                    navController.navigate(NavRoutes.PET_INFO)
                },
                onNextClicked = {
                    // TODO: Navigate to booking or next module
                }
            )
        }
    }
}
