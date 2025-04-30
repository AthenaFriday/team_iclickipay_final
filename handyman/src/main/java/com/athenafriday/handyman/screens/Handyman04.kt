package com.athenafriday.handyman.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
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
fun Handyman04(navController: NavController) {
    var sortBy by remember { mutableStateOf("Recommend") }
    var priceRange by remember { mutableStateOf(30f) }
    var rating by remember { mutableStateOf(4) }

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
            Text("Filters", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(12.dp))

            // Sort dropdown (static)
            Text("Sort by", style = MaterialTheme.typography.bodyMedium)
            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {
                TextField(
                    value = sortBy,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(false) }
                )
            }
            Spacer(Modifier.height(16.dp))
            // Price/hour slider
            Text("Price/hour", style = MaterialTheme.typography.bodyMedium)
            Slider(
                value = priceRange,
                onValueChange = { priceRange = it },
                valueRange = 0f..60f,
                steps = 2,
                modifier = Modifier.fillMaxWidth()
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("0")
                Text("30")
                Text("60")
            }
            Spacer(Modifier.height(16.dp))
            // Star rating selector
            Text("Rate", style = MaterialTheme.typography.bodyMedium)
            Row {
                (1..5).forEach { i ->
                    IconButton(onClick = { rating = i }) {
                        Icon(
                            imageVector = if (i <= rating) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        Button(
            onClick = { /* apply filter */ },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text("Apply")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman04Preview() {
    Handyman04(navController = rememberNavController())
}