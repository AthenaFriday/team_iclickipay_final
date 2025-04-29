package com.athenafriday.uberjerome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.athenafriday.uberjerome.navigation.UberDestinations

@Composable
fun CarArrivingScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
        ) {
            // Map placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("Car on the way", color = Color.White, fontSize = 24.sp)
            }

            // Car info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Your car is coming in 2:50", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { navController.navigate(UberDestinations.TripInProgress) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Message Driver")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Maybe call driver here */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Call Driver")
                }
            }
        }
    }
}
