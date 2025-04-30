package com.athenafriday.chatcarlos.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTabScaffold(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    val tabs = listOf("Chats" to "chat_list", "Contacts" to "contacts", "Calls" to "calls")
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val selectedIndex = tabs.indexOfFirst { it.second == currentRoute }.coerceAtLeast(0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chat") }
            )
        },
        content = content,
        bottomBar = {
            TabRow(selectedTabIndex = selectedIndex) {
                tabs.forEachIndexed { index, (label, route) ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = { navController.navigate(route) },
                        text = { Text(label) }
                    )
                }
            }
        }
    )
}
