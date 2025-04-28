package com.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.navigation.UberDestinations

@Composable
fun TripInProgressScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("Trip in Progress...", color = Color.White, fontSize = 24.sp)
            }

            Button(
                onClick = { navController.navigate(UberDestinations.TripComplete) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(16.dp)
            ) {
                Text("Arrive at Destination", fontSize = 18.sp)
            }
        }
    }
}
