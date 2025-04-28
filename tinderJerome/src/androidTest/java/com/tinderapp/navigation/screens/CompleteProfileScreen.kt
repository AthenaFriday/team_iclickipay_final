package com.tinderapp.navigation.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.tinderapp.navigation.TinderDestinations

@Composable
fun CompleteProfileScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // ✅ Scaffold padding first
                .padding(24.dp)          // ✅ Your custom padding
        ) {
            Text(
                text = "Complete Your Profile",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(TinderDestinations.Geolocation) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompleteProfileScreenPreview() {
    CompleteProfileScreen(navController = rememberNavController())
}
