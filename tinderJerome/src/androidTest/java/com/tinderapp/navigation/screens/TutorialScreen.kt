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
fun TutorialScreen(navController: NavController) {
    Scaffold { paddingValues ->  // ✅ Capture padding values
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // ✅ System bar padding
                .padding(24.dp)          // ✅ App-specific padding
        ) {
            Text(
                text = "Learn How to Swipe!",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(TinderDestinations.Swipe) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Start Swiping")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialScreenPreview() {
    TutorialScreen(navController = rememberNavController())
}
