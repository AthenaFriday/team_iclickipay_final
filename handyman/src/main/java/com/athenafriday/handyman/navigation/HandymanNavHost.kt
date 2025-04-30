package com.athenafriday.handyman.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.handyman.screens.*

@Composable
fun HandymanNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HandymanDestinations.Handyman00
    ) {
        composable(HandymanDestinations.Handyman00) { Handyman00(navController) }
        composable(HandymanDestinations.Handyman01) { Handyman01(navController) }
        composable(HandymanDestinations.Handyman02) { Handyman02(navController) }
        composable(HandymanDestinations.Handyman03) { Handyman03(navController) }
        composable(HandymanDestinations.Handyman04) { Handyman04(navController) }
        composable(HandymanDestinations.Handyman05) { Handyman05(navController) }
        composable(HandymanDestinations.Handyman06) { Handyman06(navController) }
        composable(HandymanDestinations.Handyman07) { Handyman07(navController) }
    }
}
