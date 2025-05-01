package com.athenafriday.handyman.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.handyman.R

private val Orange500 = Color(0xFFF77E1B)
private val DarkText   = Color(0xFF1F1F1F)
private val GrayText   = Color(0xFF9E9E9E)
private val BorderGray = Color(0xFFCCCCCC)

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .pointerInput(Unit) {
                    detectTapGestures { /* focus logic */ }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = DarkText, fontSize = 16.sp),
                decorationBox = { inner ->
                    if (query.isEmpty()) {
                        Text("Search", color = GrayText, fontSize = 16.sp)
                    }
                    inner()
                },
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Search icon",
                tint = GrayText
            )
        }
    }
}

@Composable
fun MapMarker(
    avatarRes: Int,
    offsetX: Dp,
    offsetY: Dp
) {
    Image(
        painter = painterResource(avatarRes),
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .offset(x = offsetX, y = offsetY)
            .clip(CircleShape)
            .background(Color.White, CircleShape)
            .padding(2.dp)
    )
}

@Composable
fun SummaryCard(
    name: String,
    avatarRes: Int,
    rating: String,
    distance: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .width(180.dp)
            .height(100.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(avatarRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(8.dp))
                Text(name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = DarkText)
            }
            Spacer(Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Orange500, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text(rating, color = DarkText, fontSize = 14.sp)
                }
                Text(distance, color = GrayText, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun Handyman03(navController: NavController) {
    var query by remember { mutableStateOf("") }

    // sample markers
    val markers = listOf(
        R.drawable.jessy_jones to Pair(40.dp, 120.dp),
        R.drawable.jessy_jones to Pair(240.dp, 80.dp),
        R.drawable.jessy_jones to Pair(80.dp, 280.dp),
        R.drawable.jessy_jones to Pair(280.dp, 300.dp)
    )

    // sample summaries
    val summaries = listOf(
        Triple("Jenny Jones", R.drawable.jessy_jones, "4.8 • 4.5 Mile"),
        Triple("Jean Down",   R.drawable.jessy_jones, "4.8 • 4.5 Mile")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Map background placeholder
        Image(
            painter = painterResource(R.drawable.map_placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Home button
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .background(Color.White, CircleShape)
                .align(Alignment.TopStart)
        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Orange500)
        }

        // Filter & List buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("handyman04") },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(Icons.Default.Star, contentDescription = "Filter", tint = Orange500)
            }
            IconButton(
                onClick = { navController.navigate("handyman02") },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(Icons.Default.List, contentDescription = "List", tint = Orange500)
            }
        }

        // Search bar
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp, vertical = 80.dp)
        )

        // Markers
        markers.forEach { (avatar, pos) ->
            MapMarker(
                avatarRes = avatar,
                offsetX = pos.first,
                offsetY = pos.second
            )
        }

        // Bottom summary cards — now clickable to handyman05
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            items(summaries) { (name, avatar, info) ->
                val (rating, distance) = info.split("•").map { it.trim() }
                Box(
                    modifier = Modifier
                        .clickable { navController.navigate("handyman06") }
                ) {
                    SummaryCard(
                        name     = name,
                        avatarRes= avatar,
                        rating   = rating,
                        distance = distance
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman03Preview() {
    Handyman03(navController = rememberNavController())
}
