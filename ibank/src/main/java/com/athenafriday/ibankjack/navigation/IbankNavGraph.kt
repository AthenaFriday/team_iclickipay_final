package com.athenafriday.ibankjack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.ibankjack.screen.*

@Composable
fun IbankNavGraph(main_app_navController: NavHostController) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            IbankWelcomeScreen(
//                onBackClick = { navController.popBackStack() },
                onLetsGoClick = { navController.navigate(Screen.Transactions.route) }
            )
        }
        composable(Screen.Transactions.route) {
            TransactionsScreen(
                onTransactionClick = {navController.navigate(Screen.TransactionDetail.route)},
                onHomeClick = {main_app_navController.navigate("dashboard")},
                onAddCardClick = {
                    navController.navigate(Screen.AddCard.route)
                },
                onShowCategoriesClick = {navController.navigate(Screen.Categories.route)}
            )
        }
        composable(Screen.AddCard.route) {
            AddCardScreen(
                onBackClick = { navController.popBackStack() },
                onAddCardClick = { navController.navigate(Screen.Transactions.route) }
            )
        }
        composable(Screen.TransactionDetail.route) {
            TransactionDetailScreen(

                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.Categories.route) {
            CategoriesScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        // add more screens here...
    }
}

