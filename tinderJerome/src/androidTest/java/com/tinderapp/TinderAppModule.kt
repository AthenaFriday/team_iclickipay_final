package com.tinderapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.tinderapp.navigation.TinderNavHost

@Composable
fun TinderAppModule() {
    val navController = rememberNavController()
    TinderNavHost(navController = navController)
}
