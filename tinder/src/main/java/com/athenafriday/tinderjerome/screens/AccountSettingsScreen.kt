package com.athenafriday.tinderjerome.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class) // ✅ Opt into experimental Material3 API
@Composable
fun AccountSettingsScreen(onBackClick: () -> Unit) {
    var distance by remember { mutableStateOf(50f) }
    var ageRange by remember { mutableStateOf(25f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
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
    AccountSettingsScreen(onBackClick = {})
}
