package com.athenafriday.learn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.learn.screens.*

@Composable
fun LearnNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LearnDestinations.LEARN_00
    ) {
        composable(LearnDestinations.LEARN_00) { Learn00(navController) }
        composable(LearnDestinations.LEARN_01) { Learn01(navController) }
        composable(LearnDestinations.LEARN_02) { Learn02(navController) }
        composable(LearnDestinations.LEARN_03) { Learn03(navController) }
        composable(LearnDestinations.LEARN_04) { Learn04(navController) }
        composable(LearnDestinations.LEARN_05) { Learn05(navController) }
        composable(LearnDestinations.LEARN_06) { Learn06(navController) }
        composable(LearnDestinations.LEARN_07) { Learn07(navController) }
    }
}
