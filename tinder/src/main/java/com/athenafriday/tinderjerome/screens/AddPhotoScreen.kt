package com.athenafriday.tinderjerome.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.tinderjerome.navigation.TinderDestinations

@Composable
fun AddPhotoScreen(navController: NavController) {
    Scaffold { paddingValues ->  // ✅ Use padding from Scaffold
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // ✅ Apply scaffold padding
                .padding(24.dp)  // ✅ Then your custom padding
        ) {
            Text(text = "Add a Profile Photo", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(TinderDestinations.TakePhoto) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Upload Photo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPhotoScreenPreview() {
    AddPhotoScreen(navController = rememberNavController())
}
