package com.athenafriday.ibankjack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.ibankjack.screen.*

@Composable
fun IbankNavGraph() {
    // Create a NavController inside IbankNavGraph
    val navController = rememberNavController()

    // Use the NavController within a NavHost
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            IbankWelcomeScreen(
                onLetsGoClick = { navController.navigate(Screen.Transactions.route) }
            )
        }

        composable(Screen.Transactions.route) {
            TransactionsScreen(
                onTransactionClick = { navController.navigate(Screen.TransactionDetail.route) },
                onHomeClick = { navController.navigate("dashboard") }, // Assuming "dashboard" is a valid route
                onAddCardClick = { navController.navigate(Screen.AddCard.route) },
                onShowCategoriesClick = { navController.navigate(Screen.Categories.route) }
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

        // Add more screens here if needed...
    }
}
