package com.athenafriday.iclickipay.ui.premium


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.iclickipay.R

@Composable
fun Premium09(
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top spacing
            Spacer(modifier = Modifier.height(16.dp))

            // Middle content
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Summary",
                    fontSize = 24.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Document
                Image(
                    //todo get document pic from Simadre
                    painter = painterResource(id = R.drawable.selfie_main),
                    contentDescription = "Uploaded Document",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )

                Text(
                    text = "Document",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Selfie
                Image(
                    painter = painterResource(id = R.drawable.fake_id_pic),
                    contentDescription = "Uploaded Selfie",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .width(120.dp)
                        .border(
                            border= BorderStroke(6.dp, Color(0xFFFFFFFF)),
                            shape = RoundedCornerShape(13.dp)

                            )
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(13.dp))
                        //.padding(16.dp)
                        .clip(RoundedCornerShape(13.dp))
                )

                Text(
                    text = "Selfie",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            // Bottom "Send Documents" button
            Button(
                onClick = onNextClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(70.dp)
            ) {
                Text(text = "Send documents", color = Color.White)
            }
        }
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun Premium09preview() {
    Premium09()
}