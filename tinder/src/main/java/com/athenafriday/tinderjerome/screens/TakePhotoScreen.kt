package com.athenafriday.tinderjerome.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TakePhotoScreen(
    onNext: () -> Unit
) {
    Scaffold { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Button(
                onClick = onNext
            ) {
                Text(text = "Take a Photo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoScreenPreview() {
    TakePhotoScreen(onNext = {})
}
