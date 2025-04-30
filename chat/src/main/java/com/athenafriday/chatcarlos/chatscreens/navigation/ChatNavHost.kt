package com.athenafriday.chatcarlos.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import com.athenafriday.chatcarlos.chatscreens.ChatListScreen
import com.athenafriday.chatcarlos.chatscreens.ContactListScreen
import com.athenafriday.chatcarlos.chatscreens.CallListScreen

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()

    ChatTabScaffold(navController = navController) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "chat_list",
        ) {
            composable("chat_list") { ChatListScreen() }
            composable("contacts") { ContactListScreen() }
            composable("calls") { CallListScreen() }
        }
    }
}
