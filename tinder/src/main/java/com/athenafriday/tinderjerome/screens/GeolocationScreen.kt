package com.athenafriday.tinderjerome.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.athenafriday.tinderjerome.navigation.TinderDestinations

@Composable
fun GeolocationScreen(navController: NavController) {
    Scaffold { paddingValues -> // ✅ Accept paddingValues
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // ✅ Apply system bars padding
                .padding(24.dp)         // ✅ Plus your normal 24dp padding
        ) {
            Text(text = "Enable Location", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(TinderDestinations.Tutorial) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Enable Location")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GeolocationScreenPreview() {
    GeolocationScreen(navController = rememberNavController())
}
