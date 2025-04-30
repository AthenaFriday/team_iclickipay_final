package com.athenafriday.pet.screens.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.pet.R

@Composable
fun WelcomeScreen(
    onNextClicked: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        // Back Arrow at Top Start
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }

        // Main Content Centered
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.walking_dog),
                contentDescription = "Welcome image",
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Pet",
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp),
                color = Color.Black
            )

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                textAlign = TextAlign.Center,
                color = Color(0xFF607D8B),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = onNextClicked,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(70.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F27))
            ) {
                Text("Let’s go", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}