package com.athenafriday.learn.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
private val BorderGray = Color(0xFFCCCCCC)

@Composable
fun SearchField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, BorderGray),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .pointerInput(Unit) {
                    detectTapGestures { /* focus logic if needed */ }
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                singleLine = true,
                textStyle = TextStyle(color = DarkText, fontSize = 16.sp),
                decorationBox = { inner ->
                    if (text.isEmpty()) {
                        Text(placeholder, color = GrayText, style = MaterialTheme.typography.bodyMedium)
                    }
                    inner()
                },
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = GrayText
            )
        }
    }
}

@Composable
fun TechnicianCard(
    navController: NavController,
    name: String,
    location: String,
    skills: List<String>,
    rating: String,
    distance: String,
    price: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(R.drawable.teacher_photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                )
                IconButton(
                    onClick = { navController.navigate("learn03") },
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White, shape = CircleShape)
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = GrayText)
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(name, fontWeight = FontWeight.Bold, color = DarkText)
                    Text(location, color = GrayText, style = MaterialTheme.typography.bodySmall)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(skills.joinToString(", "), color = DarkText, style = MaterialTheme.typography.bodySmall)
                }
            }

            Spacer(Modifier.height(12.dp))
            Divider(color = BorderGray, thickness = 1.dp)
            Spacer(Modifier.height(8.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Orange500, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text(rating, color = DarkText, style = MaterialTheme.typography.bodySmall)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.DirectionsWalk, contentDescription = null, tint = GrayText, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text(distance, color = DarkText, style = MaterialTheme.typography.bodySmall)
                }
                Text(price, color = DarkText, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(Modifier.height(12.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Learn02(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val scroll = rememberScrollState()
    val lesson   = "English"
    val level    = "College"
    val date     = "20 Mar - 10h"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .background(Color.White)
    ) {
        // Header image with home icon
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.learn_header),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(16.dp)
                    .size(40.dp)
                    .background(Color.White, shape = CircleShape)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Orange500
                )
            }
        }

        // Search card
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-48).dp)
                .padding(horizontal = 16.dp)
                .clickable { navController.navigate("learn05") }
        ) {
            Column {
                // Location row
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Johannesburg, 1 Road Ubuntu",
                        fontWeight = FontWeight.Medium,
                        color = DarkText,
                        style = MaterialTheme.typography.titleMedium
                    )
                    IconButton(onClick = { /* locate */ }) {
                        Icon(
                            Icons.Default.MyLocation,
                            contentDescription = "Locate",
                            tint = Orange500
                        )
                    }
                }
                Divider(color = BorderGray, thickness = 1.dp)
                // Date, Lesson & Level
                Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(16.dp)
                    ) {
                        Text("CHOOSE DATE", color = GrayText, fontSize = 12.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(date, fontWeight = FontWeight.Medium, color = DarkText)
                    }
                    Divider(color = BorderGray, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp))
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(16.dp)
                    ) {
                        Text("LESSON", color = GrayText, fontSize = 12.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(lesson, fontWeight = FontWeight.Medium, color = DarkText)
                    }
                    Divider(color = BorderGray, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp))
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(16.dp)
                    ) {
                        Text("LEVEL", color = GrayText, fontSize = 12.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(level, fontWeight = FontWeight.Medium, color = DarkText)
                    }
                }
                Divider(color = BorderGray, thickness = 1.dp)
                Spacer(Modifier.height(8.dp))
                // Search input
                SearchField(
                    text = searchQuery,
                    onTextChange = { searchQuery = it },
                    placeholder = "Search location / name",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(Modifier.height(8.dp))
                // Search button
                Button(
                    onClick = { /* search */ },
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Orange500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 32.dp)
                ) {
                    Text("Search", color = Color.White)
                }
                Spacer(Modifier.height(16.dp))
            }
        }

        // Favorites / Orders bar
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Orange500)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { /* favorites */ },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text("Favorites", color = Color.White)
                }
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { navController.navigate("learn07") },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ReceiptLong, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text("Orders", color = Color.White)
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Teachers header
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Teachers", fontWeight = FontWeight.Bold, color = DarkText)
                Spacer(Modifier.width(8.dp))
                Text("120", color = GrayText)
            }
            IconButton(onClick = { navController.navigate("learn04") }) {
                Icon(Icons.Default.Tune, contentDescription = null, tint = Orange500)
            }
        }

        Spacer(Modifier.height(8.dp))

        // Multiple teacher cards
        val teachers = listOf(
            TechnicianData("Jessy Jones", "Johannesburg", listOf("English", "French"), "4.8", "500 m", "$15/h")
        )
        Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(vertical = 8.dp)) {
            teachers.forEach { tech ->
                TechnicianCard(
                    navController = navController,
                    name     = tech.name,
                    location = tech.location,
                    skills   = tech.skills,
                    rating   = tech.rating,
                    distance = tech.distance,
                    price    = tech.price
                )
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

data class TechnicianData(
    val name: String,
    val location: String,
    val skills: List<String>,
    val rating: String,
    val distance: String,
    val price: String
)

@Preview(showBackground = true)
@Composable
fun Learn02Preview() {
    Learn02(navController = rememberNavController())
}
