package com.athenafriday.learn.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Learn01(navController: NavController) {
    var lesson by remember { mutableStateOf("English") }
    var level by remember { mutableStateOf("College") }
    var availability by remember { mutableStateOf(14f) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }

        Column {
            Text("Your teacher", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {
                TextField(
                    value = lesson,
                    onValueChange = {},
                    label = { Text("Lesson") },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = false) }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {
                TextField(
                    value = level,
                    onValueChange = {},
                    label = { Text("Level") },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = false) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

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
            onClick = { navController.navigate("learn02") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Learn01Preview() {
    Learn01(navController = rememberNavController())
}
