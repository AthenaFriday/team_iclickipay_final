package com.athenafriday.tinderjerome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.tinderjerome.screens.*

@Composable
fun TinderNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = TinderDestinations.Welcome) {
        composable(TinderDestinations.Welcome) { WelcomeScreen(navController) }
        composable(TinderDestinations.AddPhoto) { AddPhotoScreen(navController) }
        composable(TinderDestinations.TakePhoto) { TakePhotoScreen(navController) }
        composable(TinderDestinations.CompleteProfile) { CompleteProfileScreen(navController) }
        composable(TinderDestinations.Geolocation) { GeolocationScreen(navController) }
        composable(TinderDestinations.Tutorial) { TutorialScreen(navController) }
        composable(TinderDestinations.Swipe) { SwipeScreen(navController) }
        composable(TinderDestinations.ProfileDetails) { ProfileDetailsScreen(navController) }
        composable(TinderDestinations.Boost) { BoostScreen(navController) }
        composable(TinderDestinations.Like) { LikeScreen(navController) }
        composable(TinderDestinations.SuperLike) { SuperLikeScreen(navController) }
        composable(TinderDestinations.AccountSettings) { AccountSettingsScreen(navController) }
    }
}
