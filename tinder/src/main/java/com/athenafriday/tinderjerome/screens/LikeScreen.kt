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
fun LikeScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Likes") },
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
            Text("Get More Likes!", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            PurchaseOptions()
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Like logic here */ }) {
                Text(text = "Like")
            }
        }
    }
}

@Composable
private fun PurchaseOptions() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("1 Like - $1.99")
        Text("5 Likes - $5.99")
        Text("10 Likes - $9.99")
    }
}

@Preview(showBackground = true)
@Composable
fun LikeScreenPreview() {
    LikeScreen(onBackClick = {})
}
