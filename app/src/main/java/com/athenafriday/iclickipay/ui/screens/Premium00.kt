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
import com.athenafriday.iclickipay.ui.theme.LightGray
import com.athenafriday.iclickipay.ui.theme.Orange500

@Composable
fun Premium00(
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
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_rocket),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(340.dp)
            )
            Spacer(Modifier.height(32.dp))
            Text(
                "Premium account",
                style = MaterialTheme.typography.h6.copy(fontSize = 30.sp)
            )
            Spacer(Modifier.height(20.dp))
            Text(
                "Become premium to enjoy paying your friends and family, get your money back and increase the capacity of your account.",
                color = LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange500),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Let’s go", color = Color.White)
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}
