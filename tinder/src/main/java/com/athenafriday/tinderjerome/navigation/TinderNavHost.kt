package com.athenafriday.tinderjerome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.tinderjerome.screens.*
import com.athenafriday.tinderjerome.navigation.Screen



@Composable
fun TinderNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onGetStarted = { navController.navigate(Screen.AddPhoto.route) }
            )
        }

        composable(Screen.AddPhoto.route) {
            AddPhotoScreen(
                onNext = { navController.navigate(Screen.TakePhoto.route) }
            )
        }

        composable(Screen.TakePhoto.route) {
            TakePhotoScreen(
                onNext = { navController.navigate(Screen.CompleteProfile.route) }
            )
        }

        composable(Screen.CompleteProfile.route) {
            CompleteProfileScreen(
                onNext = { navController.navigate(Screen.Geolocation.route) }
            )
        }

        composable(Screen.Geolocation.route) {
            GeolocationScreen(
                onNext = { navController.navigate(Screen.Tutorial.route) }
            )
        }

        composable(Screen.Tutorial.route) {
            TutorialScreen(
                onFinishTutorial = { navController.navigate(Screen.Swipe.route) }
            )
        }

        composable(Screen.Swipe.route) {
            SwipeScreen(
                onProfileClick = { navController.navigate(Screen.ProfileDetails.route) },
                onBoostClick = { navController.navigate(Screen.Boost.route) },
                onLikeClick = { navController.navigate(Screen.Like.route) },
                onSuperLikeClick = { navController.navigate(Screen.SuperLike.route) }
            )
        }

        composable(Screen.ProfileDetails.route) {
            ProfileDetailsScreen(
                onBackClick = { navController.popBackStack() },
                onSettingsClick = { navController.navigate(Screen.AccountSettings.route) }
            )
        }

        composable(Screen.Boost.route) {
            BoostScreen(onBackClick = { navController.popBackStack() })
        }

        composable(Screen.Like.route) {
            LikeScreen(onBackClick = { navController.popBackStack() })
        }

        composable(Screen.SuperLike.route) {
            SuperLikeScreen(onBackClick = { navController.popBackStack() })
        }

        composable(Screen.AccountSettings.route) {
            AccountSettingsScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
