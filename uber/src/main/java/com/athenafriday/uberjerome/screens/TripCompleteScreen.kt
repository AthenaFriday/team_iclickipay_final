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
fun TripCompleteScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "You have arrived!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(UberDestinations.RateDriver) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Rate Driver")
            }
        }
    }
}
