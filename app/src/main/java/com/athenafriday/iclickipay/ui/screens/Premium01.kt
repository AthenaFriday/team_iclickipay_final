package com.athenafriday.iclickipay.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Card
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
fun Premium01(
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_doc_select),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(350.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text("Select your document", fontSize = 20.sp)
            Spacer(Modifier.height(8.dp))
            Text(
                "Choose a document to authenticate",
                color = LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(70.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { /* passport selected */ }
                ) {
                    Column(
                        Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_passport),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("Passport")
                    }
                }
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { /* id card selected */ }
                ) {
                    Column(
                        Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_id_card),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("ID Card")
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange500),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Next", color = Color.White)
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
