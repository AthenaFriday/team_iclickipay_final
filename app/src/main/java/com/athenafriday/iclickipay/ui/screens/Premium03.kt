package com.athenafriday.iclickipay.ui.screens

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.athenafriday.iclickipay.R
import com.athenafriday.iclickipay.ui.theme.DarkGray
import com.athenafriday.iclickipay.ui.theme.Orange500

@Composable
fun Premium03(
    onRetry: () -> Unit,
    onNext: () -> Unit,
    onHelp: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = onRetry) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back",
                            tint = Orange500
                        )
                    }
                },
                title = {
                    Text("Scan your passport", style = MaterialTheme.typography.h6)
                },
                actions = {
                    IconButton(onClick = onHelp) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_help),
                            contentDescription = "Help",
                            tint = Orange500
                        )
                    }
                }
            )
        },
        backgroundColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Camera preview placeholder + guideline overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(DarkGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_guideline),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 32.dp, top = 32.dp)
                        // size should match the asset's natural size
                        .size(width = 120.dp, height = 120.dp)
                )
            }

            // Bottom Scan button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Button(
                    onClick = onNext,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Orange500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .align(Alignment.Center)
                ) {
                    Text("Scan", color = Color.White)
                }
            }
        }
    }
}
