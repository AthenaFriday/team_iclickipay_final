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
fun SelectCarScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            // Car List
            Column(modifier = Modifier.padding(16.dp)) {
                repeat(4) {
                    CarOptionItem(name = "Gabriel F.", estimate = "$8-10", onClick = {
                        navController.navigate(UberDestinations.CarArriving)
                    })
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun CarOptionItem(name: String, estimate: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Distance 3km | 5 min", fontSize = 14.sp, color = Color.Gray)
            }
            Text(estimate, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}
