package com.athenafriday.handyman.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.handyman.R

private val Orange500 = Color(0xFFF77E1B)
private val DarkText   = Color(0xFF1F1F1F)
private val GrayText   = Color(0xFF9E9E9E)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman06(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Orange500)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                modifier = Modifier.background(Color.Transparent),
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)       // apply the scaffold’s content padding
                .fillMaxSize()
        ) {
            // Map background
            Image(
                painter = painterResource(R.drawable.map_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Content card
            Card(
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .offset(y = (-24).dp)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 56.dp, bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar overlaps
                    Box(
                        modifier = Modifier
                            .size(112.dp)
                            .offset(y = (-56).dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.jessy_jones),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(112.dp)
                                .clip(CircleShape)
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Jenny Jones",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkText
                    )

                    Spacer(Modifier.height(16.dp))

                    // Rating and rate
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = null,
                                tint = Orange500,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text("4.8", fontSize = 16.sp, color = DarkText)
                        }
                        Text(
                            "$ 15/h",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = DarkText
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Text(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                        fontSize = 14.sp,
                        color = GrayText,
                        lineHeight = 20.sp
                    )

                    Spacer(Modifier.height(24.dp))
                    Divider(color = GrayText.copy(alpha = 0.3f), thickness = 1.dp)
                    Spacer(Modifier.height(16.dp))

                    // Address row
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Place,
                            contentDescription = null,
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text("28 Broad Street", fontSize = 16.sp, color = DarkText)
                            Text("Johannesburg", fontSize = 14.sp, color = GrayText)
                        }
                    }

                    Spacer(Modifier.height(16.dp))
                    Divider(color = GrayText.copy(alpha = 0.3f), thickness = 1.dp)
                    Spacer(Modifier.height(16.dp))

                    // Skills row
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Build,
                            contentDescription = null,
                            tint = DarkText,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text("Plumber", fontSize = 16.sp, color = DarkText)
                            Text("Carpenter", fontSize = 14.sp, color = GrayText)
                        }
                    }

                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { navController.navigate("handyman05") },
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Orange500),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(
                            "Take appointment",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman06Preview() {
    Handyman06(navController = rememberNavController())
}