package com.athenafriday.tinderjerome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.tinderjerome.navigation.TinderDestinations
import com.athenafriday.tinderjerome.screens.AccountSettingsScreen
import com.athenafriday.tinderjerome.screens.AddPhotoScreen
import com.athenafriday.tinderjerome.screens.BoostScreen
import com.athenafriday.tinderjerome.screens.CompleteProfileScreen
import com.athenafriday.tinderjerome.screens.GeolocationScreen
import com.athenafriday.tinderjerome.screens.LikeScreen
import com.athenafriday.tinderjerome.screens.ProfileDetailsScreen
import com.athenafriday.tinderjerome.screens.SuperLikeScreen
import com.athenafriday.tinderjerome.screens.SwipeScreen
import com.athenafriday.tinderjerome.screens.TakePhotoScreen
import com.athenafriday.tinderjerome.screens.TutorialScreen
import com.athenafriday.tinderjerome.screens.WelcomeScreen


@Composable
fun TinderNavHost(navController: NavHostController) {
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

