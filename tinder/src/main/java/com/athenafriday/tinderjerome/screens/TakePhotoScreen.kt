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
fun TakePhotoScreen(navController: NavController) {
    Scaffold { paddingValues -> // ✅ Capture padding
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // ✅ Apply system bars padding
                .padding(24.dp)          // ✅ Plus your own custom padding
        ) {
            Button(
                onClick = { navController.navigate(TinderDestinations.CompleteProfile) }
            ) {
                Text(text = "Take a Photo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoScreenPreview() {
    TakePhotoScreen(navController = rememberNavController())
}
