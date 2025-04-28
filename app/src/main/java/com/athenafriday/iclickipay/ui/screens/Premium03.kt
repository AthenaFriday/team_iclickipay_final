package com.athenafriday.iclickipay.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.athenafriday.iclickipay.R
import com.athenafriday.iclickipay.ui.theme.DarkGray
import com.athenafriday.iclickipay.ui.theme.Orange500

@Composable
fun Premium03(
    onNext: () -> Unit,
    onRetry: () -> Unit,
    onHelp: () -> Unit = {}
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context.findActivity(),
                arrayOf(Manifest.permission.CAMERA),
                0
            )
        }
    }

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = onRetry) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            tint = Orange500,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Scan your passport",
                        style = MaterialTheme.typography.h6
                    )
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
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(DarkGray)
            ) {
                AndroidView(factory = { ctx ->
                    PreviewView(ctx).also { previewView ->
                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()
                            val preview = Preview.Builder().build().also {
                                it.setSurfaceProvider(previewView.surfaceProvider)
                            }
                            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                            cameraProvider.unbindAll()
                            cameraProvider.bindToLifecycle(
                                lifecycleOwner,
                                cameraSelector,
                                preview
                            )
                        }, ContextCompat.getMainExecutor(ctx))
                    }
                }, modifier = Modifier.matchParentSize())

                Image(
                    painter = painterResource(id = R.drawable.ic_guideline),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 32.dp, top = 32.dp)
                        .size(120.dp)
                )
            }
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
                    Text(text = "Scan", color = Color.White)
                }
            }
        }
    }
}

private fun android.content.Context.findActivity(): android.app.Activity =
    when (this) {
        is android.app.Activity -> this
        else -> throw IllegalStateException("Context is not an activity")
    }