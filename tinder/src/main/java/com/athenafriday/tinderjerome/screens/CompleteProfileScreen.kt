package com.athenafriday.tinderjerome.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CompleteProfileScreen(onNext: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text(
                text = "Complete Your Profile",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onNext,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompleteProfileScreenPreview() {
    CompleteProfileScreen(onNext = {})
}
