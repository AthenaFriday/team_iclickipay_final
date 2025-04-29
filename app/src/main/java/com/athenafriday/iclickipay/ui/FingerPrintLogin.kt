package com.athenafriday.iclickipay.ui

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.iclickipay.R
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme

@Composable
fun FingerprintLoginScreen(
    onUsePasswordClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF003399), Color(0xFF0066CC))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            onClick = {}, //TODO navigate to the sign up screen if clicked
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp) // Some space from edges
        ) {
            Text(
                text = "Sign up",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Connect to ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("iclick")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFFFF7F2A))) {
                        append("ipay")
                    }
                },
                color = Color.White,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Use fingerprint to login",
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.hdfinger),
                contentDescription = "Fingerprint",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "Or use password instead",
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(31.dp))

            Button(
                onClick = onUsePasswordClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7F2A)
                ),
                shape = CircleShape,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .height(70.dp)
                    .width(70.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.lock), // Lock icon
                    contentDescription = "Lock",
                    Modifier.size(size = 25.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FingerprintLoginScreenPreview() {
    IclickIpayTheme {
        FingerprintLoginScreen()
    }
}