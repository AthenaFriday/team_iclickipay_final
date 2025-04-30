package com.athenafriday.handyman.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman01(navController: NavController) {
    var need by remember { mutableStateOf("Plumber") }
    var problem by remember { mutableStateOf("Do not work") }
    var availability by remember { mutableStateOf(14f) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Column {
            Text("Your handyman", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(16.dp))

            // Need dropdown
            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {
                TextField(
                    value = need,
                    onValueChange = {},
                    label = { Text("Need") },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(false) }
                )
                // TODO: attach menu with listOf("Plumber","Electrician",…)
            }
            Spacer(Modifier.height(12.dp))

            // Problem dropdown
            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {
                TextField(
                    value = problem,
                    onValueChange = {},
                    label = { Text("Problem") },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(false) }
                )
            }
            Spacer(Modifier.height(24.dp))

            // Availability slider
            Text("Availability", style = MaterialTheme.typography.titleMedium)
            Slider(
                value = availability,
                onValueChange = { availability = it },
                valueRange = 8f..20f,
                steps = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf(8, 11, 14, 17, 20).forEach { hr ->
                    Text("${hr}h", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
        Button(
            onClick = { navController.navigate("handyman02") },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman01Preview() {
    Handyman01(navController = rememberNavController())
}