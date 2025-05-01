package com.athenafriday.tinderjerome.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class) // ✅ Opt-in to suppress warning
@Composable
fun BoostScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Boost") },
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text("Boost your profile!", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            PurchaseOptions()
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Boost logic here */ }) {
                Text(text = "Boost")
            }
        }
    }
}

@Composable
private fun PurchaseOptions() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("1 Boost - $1.99")
        Text("5 Boosts - $5.99")
        Text("10 Boosts - $9.99")
    }
}

@Preview(showBackground = true)
@Composable
fun BoostScreenPreview() {
    BoostScreen(onBackClick = {})
}
