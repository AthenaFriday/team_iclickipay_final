package com.athenafriday.iclickipay.ui.premium


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.iclickipay.ui.premium.*

@Composable
fun PremiumNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "premium05"
    ) {
        /*composable("premium00") {
            Premium00(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium01") }
            )
        }*/
        /*composable("premium01") {
            Premium01(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium02") }
            )
        }*/
      /*  composable("premium02") {
            Premium02(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium03") }
            )
        }*/
        /*composable("premium03") {
            Premium03(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium04") }
            )
        }*/
       /* composable("premium04") {
            Premium04(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium05") }
            )
        }*/
        composable("premium05") {
            Premium05(
                onBackClick = { navController.popBackStack() },
                onTakePictureClick = { navController.navigate("premium06") }
            )
        }
        composable("premium06") {
            Premium06(
                onBackClick = { navController.popBackStack() },
                onTakeSelfieClick = { navController.navigate("premium07") }
            )
        }
        composable("premium07") {
            Premium07(
                onBackClick = { navController.popBackStack() }
                // Capture click mocked
            )
        }
        composable("premium08") {
            Premium08(
                onBackClick = { navController.popBackStack() },
                onRetryClick = { navController.navigate("premium07") },
                onConfirmClick = { navController.navigate("premium09") }
            )
        }
        composable("premium09") {
            Premium09(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("premium10") }
            )
        }
        composable("premium10") {
            Premium10(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate("home") }
            )
        }
        composable("premium11") {
            Premium11(
                onBackClick = { navController.popBackStack() },
                onFinishClick = { navController.navigate("home") }
            )
        }

    }
}
