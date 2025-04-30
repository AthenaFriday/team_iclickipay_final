package com.athenafriday.uberjerome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    val results = listOf("Johannesburg", "Johannesburg", "Johannesburg")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                placeholder = { Text("Enter location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 16.dp),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
            ) {
                items(results) { result ->
                    LocationSearchItem(name = result)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(12.dp)) // spacing from search list

            Button(
                onClick = { navController.navigate(UberDestinations.SelectCar) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp), // lift above screen edge
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
    ) {
        Text(name, fontSize = 16.sp, color = Color.Black)
    }
}
