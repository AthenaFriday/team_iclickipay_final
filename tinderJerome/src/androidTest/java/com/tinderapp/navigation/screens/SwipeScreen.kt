package com.tinderapp.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tinderapp.navigation.TinderDestinations

@Composable
fun SwipeScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Placeholder Image - Replace with actual profile image
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_camera),
                contentDescription = "Profile",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )

            // Swipe Buttons
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = { /* Dislike */ },
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = 0.2f))
                ) {
                    Icon(Icons.Default.Close, contentDescription = "No", tint = Color.Red)
                }
                IconButton(
                    onClick = { navController.navigate(TinderDestinations.ProfileDetails) },
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray.copy(alpha = 0.2f))
                ) {
                    Icon(Icons.Default.Info, contentDescription = "Details", tint = Color.Gray)
                }
                IconButton(
                    onClick = { /* Like */ },
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Green.copy(alpha = 0.2f))
                ) {
                    Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Green)
                }
            }
        }
    }
}
