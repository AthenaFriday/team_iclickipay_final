package com.athenafriday.handyman.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman06(navController: NavController) {
    Box(Modifier.fillMaxSize()) {
        // 1️⃣ Placeholder for a MapView or Compose map
        Box(
            Modifier.fillMaxSize().background(Color(0xFFEFEFEF)),
            contentAlignment = Alignment.Center
        ) {
            Text("Map placeholder")
        }

        // 2️⃣ Search bar + icons
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search") },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            )
            IconButton(onClick = { /* toggle list */ }) {
                Icon(Icons.Default.List, contentDescription = "List view")
            }
        }

        // 3️⃣ Bottom carousel of profiles
        LazyRow(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listOf("Jenny","Jean")) { name ->
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .clickable { navController.navigate("handyman07") }
                ) {
                    Column(
                        Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(32.dp))
                        Text(name, style = MaterialTheme.typography.bodySmall)
                        Text("4.8 ★", style = MaterialTheme.typography.bodySmall)
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