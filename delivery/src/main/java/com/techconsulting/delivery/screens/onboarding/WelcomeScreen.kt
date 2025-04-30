package com.techconsulting.delivery.screens.onboarding



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
import com.athenafriday.delivery.R


@Composable
fun WelcomeScreen(
    onNextClicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.align(Alignment.Center)
        ) {
            // Replace with your actual image in drawable
            Image(
                painter = painterResource(id = R.drawable.delivery_welcome),
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Delivery",
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

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onNextClicked,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F27))
            ) {
                Text("Let’s go", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DeliveryWelcomeScreenPreview() {
    WelcomeScreen(onNextClicked = {})
}