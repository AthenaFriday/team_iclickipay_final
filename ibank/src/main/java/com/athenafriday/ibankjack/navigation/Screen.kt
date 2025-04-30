package com.athenafriday.ibankjack.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Transactions : Screen("transactions")
    object TransactionDetail : Screen("transaction_detail")
    object AddCard : Screen("add_card")
    object Categories : Screen("categories")
}
