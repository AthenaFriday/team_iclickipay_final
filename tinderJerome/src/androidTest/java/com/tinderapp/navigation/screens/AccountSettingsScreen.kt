package com.tinderapp.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AccountSettingsScreen(navController: NavController) {
    var distance by remember { mutableStateOf(50f) }
    var ageRange by remember { mutableStateOf(25f) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Distance", style = MaterialTheme.typography.titleLarge)
            Slider(
                value = distance,
                onValueChange = { distance = it },
                valueRange = 1f..100f
            )
            Text(text = "${distance.toInt()} miles")

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Age Range", style = MaterialTheme.typography.titleLarge)
            Slider(
                value = ageRange,
                onValueChange = { ageRange = it },
                valueRange = 18f..60f
            )
            Text(text = "${ageRange.toInt()} years")

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Save Settings */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Update")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountSettingsScreenPreview() {
    AccountSettingsScreen(navController = rememberNavController())
}
