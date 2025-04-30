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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.OutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Learn04(navController: NavController) {
    var sortBy by remember { mutableStateOf("Recommend") }
    var price by remember { mutableStateOf(30f) }
    var rating by remember { mutableStateOf(4) }

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
            Text("Filters", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(12.dp))

            Text("Sort by", style = MaterialTheme.typography.bodyMedium)
            ExposedDropdownMenuBox(expanded = false, onExpandedChange = {}) {
                OutlinedTextField(
                    value = sortBy,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = false) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("Price/hour", style = MaterialTheme.typography.bodyMedium)
            Slider(
                value = price,
                onValueChange = { price = it },
                valueRange = 0f..60f,
                steps = 2,
                modifier = Modifier.fillMaxWidth()
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("0"); Text("30"); Text("60")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("Rate", style = MaterialTheme.typography.bodyMedium)
            Row {
                (1..5).forEach { i ->
                    IconButton(onClick = { rating = i }) {
                        Icon(
                            imageVector = if (i <= rating) Icons.Filled.Star else Icons.Filled.StarBorder,
                            contentDescription = null
                        )
                    }
                }
            }
        }

        Button(
            onClick = { /* apply filter */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Apply")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Learn04Preview() {
    Learn04(navController = rememberNavController())
}
