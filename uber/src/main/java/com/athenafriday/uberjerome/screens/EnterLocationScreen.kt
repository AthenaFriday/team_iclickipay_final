package com.athenafriday.uberjerome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.athenafriday.uberjerome.navigation.UberDestinations

@Composable
fun EnterLocationScreen(navController: NavController) {
    var location by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            // Location Search
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                placeholder = { Text("Enter location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Search Results
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                repeat(3) {
                    LocationSearchItem(name = "Johannesburg")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Confirm Button
            Button(
                onClick = { navController.navigate(UberDestinations.SelectCar) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Confirm Location", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun LocationSearchItem(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .padding(bottom = 8.dp)
    ) {
        Text(name, fontSize = 16.sp, color = Color.Black)
    }
}
