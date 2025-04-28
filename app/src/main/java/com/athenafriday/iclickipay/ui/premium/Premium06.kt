package com.athenafriday.iclickipay.ui.premium

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.athenafriday.iclickipay.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Premium06(
    onBackClick: () -> Unit = {},
    onTakeSelfieClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Back arrow button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement  = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        modifier = Modifier.size(60.dp)
                    )
                }
                Text(
                    text = "Add a selfie",
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_questionmark),
                    contentDescription = "Question Mark",
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Transparent, shape = RoundedCornerShape(50))
                        .padding(8.dp)
                )
            }



           // Spacer(modifier = Modifier.height(8.dp))

            // Selfie Placeholder
            Image(
                painter = painterResource(id = R.drawable.selfie_placeholder), // Replace with your illustration
                contentDescription = "Selfie Guide",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            )

           // Spacer(modifier = Modifier.height(8.dp))

            // Capture Button
            Button(
                onClick = onTakeSelfieClick,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600)),
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .fillMaxWidth(.8f)
                    .height(70.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera), // Replace with your camera icon drawable
                    contentDescription = "Take Selfie",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
