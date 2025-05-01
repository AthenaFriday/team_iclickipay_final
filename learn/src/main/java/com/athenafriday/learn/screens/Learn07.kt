package com.athenafriday.learn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.learn.R

private val Orange500 = Color(0xFFF77E1B)
private val DarkText   = Color(0xFF1F1F1F)
private val GrayText   = Color(0xFF9E9E9E)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Learn07(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Order",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    TextButton(onClick = { navController.navigate("learn05") }) {
                        Text("Cancel", color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                modifier = Modifier.background(Orange500)
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Orange header
            Column(
                modifier = Modifier
                    .background(Orange500)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.teacher_photo),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(
                            "Teacher",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            "Jenny Jones",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            "Start",
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 14.sp
                        )
                        Text(
                            "20 March, Thu – 14h",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            "End",
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 14.sp
                        )
                        Text(
                            "20 March, Thu – 15h",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Place,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text("28 Broad Street", color = Color.White, fontSize = 14.sp)
                        Text("Johannesburg", color = Color.White, fontSize = 14.sp)
                    }
                }
            }

            // White content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .weight(1f)
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                // Service row
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            "English / College",
                            color = DarkText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            "Remove",
                            color = Orange500,
                            fontSize = 14.sp
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            "$ 15/h",
                            color = DarkText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            "x1",
                            color = Orange500,
                            fontSize = 14.sp
                        )
                    }
                }
                Divider(color = GrayText.copy(alpha = 0.3f), thickness = 1.dp)

                // Subtotal
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Subtotal",
                        color = DarkText,
                        fontSize = 16.sp
                    )
                    Text(
                        "$ 15.00",
                        color = Orange500,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Delivery fees
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Delivery fees",
                        color = DarkText,
                        fontSize = 16.sp
                    )
                    Text(
                        "$ 0.00",
                        color = GrayText,
                        fontSize = 16.sp
                    )
                }

                Divider(color = GrayText.copy(alpha = 0.3f), thickness = 1.dp, modifier = Modifier.padding(vertical = 16.dp))

                // Total amount
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Total amount",
                        color = GrayText,
                        fontSize = 14.sp
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "$ 15.00",
                        color = Orange500,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Place order button
            Button(
                onClick = { navController.navigate("learn00") },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange500),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .height(56.dp)
            ) {
                Text(
                    "Place order",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Learn07Preview() {
    Learn07(navController = rememberNavController())
}
