package com.athenafriday.iclickipay.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.iclickipay.R
import com.athenafriday.iclickipay.ui.theme.Orange500
import com.athenafriday.iclickipay.ui.theme.LightGray

@Composable
fun Premium02(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(painter = painterResource(id = R.drawable.ic_back), tint = Orange500, contentDescription = "Back")
                    }
                },
                title = {}
            )
        },
        backgroundColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(300.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text("Scan your passport", fontSize = 20.sp)
            Spacer(Modifier.height(15.dp))
            Text(
                "Take a photo of your valid passport.\nPlace it within the brackets.",
                color = LightGray,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(250.dp)
            )
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange500),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Scan", color = Color.White)
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}
