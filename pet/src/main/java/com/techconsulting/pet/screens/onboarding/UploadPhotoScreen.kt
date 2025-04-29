package com.techconsulting.pet.screens.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athenafriday.pet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TakePhotoScreen(
    onBackClicked: () -> Unit = {},
    onTakePhotoClicked: () -> Unit = {},
    onHelpClicked: () -> Unit = {},
    onFlashClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Take a photo") },
                navigationIcon = {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onFlashClicked) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_flash),
                            contentDescription = "Flash"
                        )
                    }
                    IconButton(onClick = onHelpClicked) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_help),
                            contentDescription = "Help"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Dog photo
            Image(
                painter = painterResource(id = R.drawable.fake_photo),
                contentDescription = "Dog photo",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            // Camera button
            Button(
                onClick = onTakePhotoClicked,
                modifier = Modifier
                    .padding(24.dp)
                    .height(60.dp)
                    .fillMaxWidth(0.8f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFFF7F27))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Take photo",
                    tint = Color.White
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoScreenPreview() {
    TakePhotoScreen()
}