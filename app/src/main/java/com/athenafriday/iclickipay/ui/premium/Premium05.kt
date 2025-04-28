package com.athenafriday.iclickipay.ui.premium
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.athenafriday.iclickipay.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Premium05(
    onBackClick: () -> Unit = {},
    onTakePictureClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Top Back Arrow
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(30.dp)
                    .clickable {
                    // Handle back click
                        }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(5.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Main Image
                Image(
                    painter = painterResource(id = R.drawable.selfie_main),
                    contentDescription = "Selfie Illustration",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Title
                Text(
                    text = "Add a selfie",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    ),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    text = "Your face must be clearly visible and have\n" +
                            "the same expression as on your document.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp
                    ),
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Small Image inside a Circle

                    Image(
                        painter = painterResource(id = R.drawable.person_icon),
                        contentDescription = "Person Icon",
                        modifier = Modifier.size(150.dp)
                    )
                
            }

            // Bottom Button
            Button(
                onClick = onTakePictureClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6600) // Bright orange
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(70.dp)
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Take a picture",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}





