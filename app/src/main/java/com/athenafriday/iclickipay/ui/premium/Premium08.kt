package com.athenafriday.iclickipay.ui.premium


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.athenafriday.iclickipay.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Premium08(
    onBackClick: () -> Unit = {},
    onRetryClick: () -> Unit = {},
    onConfirmClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top section with back button
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back"
                    )
                }
            }

            // Middle content
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    //todo: replace with actual image capture
                    painter = painterResource(id = R.drawable.fake_id_pic),
                    contentDescription = "Captured Selfie",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(400.dp)
                        .width(280.dp)
                        .border(
                            border= BorderStroke(6.dp, Color(0xFFFFFFFF)),
                            shape = RoundedCornerShape(13.dp)

                        )
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(13.dp))
                        //.padding(16.dp)
                        .clip(RoundedCornerShape(13.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Confirm your selfie",
                    fontSize = 22.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Check the integrity of your picture",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            // Bottom buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    onClick = onRetryClick,
                    border = BorderStroke(1.dp, Color(0xFFFF6600)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp)
                        .padding(end = 8.dp)
                ) {
                    Text(text = "Retry", color = Color(0xFFFF6600))
                }

                Button(
                    onClick = onConfirmClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp)
                        .padding(start = 8.dp)
                ) {
                    Text(text = "Confirm", color = Color.White)
                }
            }
        }
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun Premium08preview() {
    Premium08()
}