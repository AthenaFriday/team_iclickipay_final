package com.athenafriday.iclickipay

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.iclickipay.ui.screens.Premium00
import com.athenafriday.iclickipay.ui.screens.Premium01
import com.athenafriday.iclickipay.ui.screens.Premium02
import com.athenafriday.iclickipay.ui.screens.Premium03
import com.athenafriday.iclickipay.ui.screens.Premium04


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Premium00") {
        composable("Premium00") {
            Premium00(
                onNext = { navController.navigate("Premium01") },
                onBack = { /* handle system back */ }
            )
        }
        composable("Premium01") {
            Premium01(
                onNext = { navController.navigate("Premium02") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("Premium02") {
            Premium02(
                onNext = { navController.navigate("Premium03") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("Premium03") {
            Premium03(
                onRetry = { navController.popBackStack("Premium02", inclusive = false) },
                onNext  = { navController.navigate("Premium04") }
            )
        }
        composable("Premium04") {
            Premium04(
                onConfirm = { /* final action */ },
                onBack    = { navController.popBackStack() }
            )
        }
    }
}
