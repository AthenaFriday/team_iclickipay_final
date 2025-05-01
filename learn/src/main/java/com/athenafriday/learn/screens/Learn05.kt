package com.athenafriday.learn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
fun Learn05(navController: NavController) {
    // state
    var selectedDay  by remember { mutableStateOf(6) }
    var selectedTime by remember { mutableStateOf(0) }

    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val dates      = listOf(4, 5, 6, 7, 8, 9, 10)
    val times      = listOf(
        "01:00 PM", "01:30 PM", "02:00 PM", "02:30 PM",
        "03:00 PM", "03:30 PM", "04:00 PM"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* empty */ },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Orange500)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Avatar + name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.teacher_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Jenny Jones",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = DarkText
                )
            }

            Spacer(Modifier.height(24.dp))

            // Month selector
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.weight(1f))
                Text(
                    "March 2019",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = DarkText
                )
                IconButton(onClick = { /* next month */ }) {
                    Icon(
                        Icons.Default.ArrowForwardIos,
                        contentDescription = "Next month",
                        tint = Orange500
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // Days of week
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                daysOfWeek.forEach { day ->
                    Text(day, color = GrayText, fontSize = 14.sp)
                }
            }

            Spacer(Modifier.height(8.dp))

            // Dates row
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                dates.forEach { date ->
                    val selected = date == selectedDay
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(if (selected) Orange500 else Color.Transparent)
                            .clickable { selectedDay = date }
                    ) {
                        Text(
                            date.toString(),
                            color = if (selected) Color.White else DarkText,
                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))
            Divider(color = GrayText, thickness = 1.dp)
            Spacer(Modifier.height(8.dp))

            // Time slots
            times.forEachIndexed { idx, time ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedTime = idx }
                        .padding(vertical = 12.dp)
                ) {
                    if (idx == selectedTime) {
                        Box(
                            Modifier
                                .size(8.dp)
                                .background(Orange500, shape = CircleShape)
                        )
                    } else {
                        Spacer(Modifier.width(8.dp))
                    }
                    Spacer(Modifier.width(16.dp))
                    Text(
                        time,
                        fontSize = 16.sp,
                        fontWeight = if (idx == selectedTime) FontWeight.Medium else FontWeight.Normal,
                        color = if (idx == selectedTime) DarkText else GrayText
                    )
                }
                Divider(color = GrayText.copy(alpha = 0.3f), thickness = 1.dp)
            }

            Spacer(Modifier.height(24.dp))

            // Confirm button
            Button(
                onClick = { navController.navigate("learn06") },
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

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Learn05Preview() {
    Learn05(navController = rememberNavController())
}