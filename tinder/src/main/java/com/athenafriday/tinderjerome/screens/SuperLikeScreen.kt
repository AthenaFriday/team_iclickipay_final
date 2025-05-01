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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperLikeScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Super Like") },
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
            Text("Super Like someone!", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            PurchaseOptions()
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Super Like logic here */ }) {
                Text(text = "Super Like")
            }
        }
    }
}

@Composable
private fun PurchaseOptions() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("1 Super Like - $1.99")
        Text("5 Super Likes - $5.99")
        Text("10 Super Likes - $9.99")
    }
}

@Preview(showBackground = true)
@Composable
fun SuperLikeScreenPreview() {
    SuperLikeScreen(onBackClick = {})
}
