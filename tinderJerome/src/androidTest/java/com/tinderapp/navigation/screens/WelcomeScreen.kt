package com.tinderapp.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tinderapp.navigation.TinderDestinations

@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold { paddingValues ->  // ✅ capture paddingValues
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // ✅ system padding
                .padding(16.dp)          // ✅ your custom padding
        ) {
            Button(
                onClick = { navController.navigate(TinderDestinations.AddPhoto) }
            ) {
                Text(text = "Get Started")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}
