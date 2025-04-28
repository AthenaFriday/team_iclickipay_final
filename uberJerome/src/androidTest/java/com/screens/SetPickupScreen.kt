package com.screens

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
import com.navigation.UberDestinations

@Composable
fun SetPickupScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
        ) {
            // Top - Map Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Map View - Pickup",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Bottom - Pickup Location Input
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Set pick up location") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(12.dp)
                )

                Text(
                    text = "Saved Places",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                SavedPlaceItem(title = "Home", address = "456 Home Avenue, City")

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { navController.navigate(UberDestinations.EnterLocation) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Confirm Pickup Location")
                }
            }
        }
    }
}
