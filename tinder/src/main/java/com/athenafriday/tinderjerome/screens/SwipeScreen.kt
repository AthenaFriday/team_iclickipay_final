package com.athenafriday.tinderjerome.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.athenafriday.tinderjerome.data.Profile
import kotlinx.coroutines.launch

@Composable
fun SwipeScreen(
    onProfileClick: () -> Unit,
    onBoostClick: () -> Unit,
    onLikeClick: () -> Unit,
    onSuperLikeClick: () -> Unit
) {
    val profiles = remember {
        mutableStateListOf(
            Profile("Alice", 25, com.athenafriday.tinderjerome.R.drawable.person1),
            Profile("Bob", 30, com.athenafriday.tinderjerome.R.drawable.person2),
            Profile("Cara", 27, com.athenafriday.tinderjerome.R.drawable.person3)
        )
    }

    var showInfoDialog by remember { mutableStateOf(false) }
    val offsetX = remember { Animatable(0f) }
    val swipeThreshold = 300f
    val coroutineScope = rememberCoroutineScope()

    if (profiles.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No more profiles", style = MaterialTheme.typography.titleLarge)
        }
        return
    }

    val profile = profiles.first()

    if (showInfoDialog) {
        AlertDialog(
            onDismissRequest = { showInfoDialog = false },
            title = { Text("${profile.name}, ${profile.age}") },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = profile.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("This is ${profile.name}. They enjoy traveling, music, and trying new food.")
                }
            },
            confirmButton = {
                TextButton(onClick = { showInfoDialog = false }) {
                    Text("Close")
                }
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .graphicsLayer {
                    translationX = offsetX.value
                    rotationZ = (offsetX.value / 60).coerceIn(-40f, 40f)
                }
                .pointerInput(profiles) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { change, dragAmount ->
                            change.consume()
                            coroutineScope.launch {
                                offsetX.snapTo(offsetX.value + dragAmount)
                            }
                        },
                        onDragEnd = {
                            coroutineScope.launch {
                                when {
                                    offsetX.value > swipeThreshold -> {
                                        offsetX.animateTo(1000f, tween(300))
                                        profiles.removeAt(0)
                                        offsetX.snapTo(0f)
                                        onLikeClick()
                                    }

                                    offsetX.value < -swipeThreshold -> {
                                        offsetX.animateTo(-1000f, tween(300))
                                        profiles.removeAt(0)
                                        offsetX.snapTo(0f)
                                    }

                                    else -> {
                                        offsetX.animateTo(0f, tween(300))
                                    }
                                }
                            }
                        }
                    )
                },
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(profile.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "${profile.name}, ${profile.age}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        // Bottom Buttons
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        offsetX.animateTo(-1000f, tween(300))
                        profiles.removeAt(0)
                        offsetX.snapTo(0f)
                    }
                },
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Red.copy(alpha = 0.2f))
            ) {
                Icon(Icons.Default.Close, contentDescription = "Dislike", tint = Color.Red)
            }

            IconButton(
                onClick = {
                    showInfoDialog = true
                    onProfileClick()
                },
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Gray.copy(alpha = 0.2f))
            ) {
                Icon(Icons.Default.Info, contentDescription = "Info", tint = Color.Gray)
            }

            IconButton(
                onClick = {
                    coroutineScope.launch {
                        offsetX.animateTo(1000f, tween(300))
                        profiles.removeAt(0)
                        offsetX.snapTo(0f)
                        onSuperLikeClick()
                    }
                },
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Green.copy(alpha = 0.2f))
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Green)
            }
        }
    }

    // Optional Boost Call
    LaunchedEffect(Unit) {
        onBoostClick()
    }
}
