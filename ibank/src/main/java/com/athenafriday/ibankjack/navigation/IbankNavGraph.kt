package com.athenafriday.ibankjack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athenafriday.ibankjack.screen.*

@Composable
fun IbankNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            IbankWelcomeScreen(
                onBackClick = { navController.popBackStack() },
                onLetsGoClick = { navController.navigate(Screen.Transactions.route) }
            )
        }
        composable(Screen.Transactions.route) {
            TransactionsScreen(
                onTransactionClick = {},
                onHomeClick = {},
                onAddCardClick = {
                    navController.navigate(Screen.AddCard.route)
                }
            )
        }
        composable(Screen.AddCard.route) {
            AddCardScreen(
                onBackClick = { navController.popBackStack() },
                onAddCardClick = { navController.navigate(Screen.Transactions.route) }
            )
        }
        // add more screens here...
    }
}

