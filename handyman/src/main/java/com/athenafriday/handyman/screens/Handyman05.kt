package com.athenafriday.handyman.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.handyman.R

@Composable
fun Handyman05(navController: NavController) {
    Column {
        // Header image + home icon
        Box {
            Image(
                painter = painterResource(R.drawable.handyman_header),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /* go home */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Default.Home, contentDescription = "Home", tint = MaterialTheme.colorScheme.onPrimary)
            }
        }

        Spacer(modifier = Modifier.height( -40.dp)) // overlap effect

        // Search card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Johannesburg, 1 Road Ubuntu")
                Spacer(modifier = Modifier.height(8.dp))
                Text("CHOOSE DATE  20 Mar - 10h", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Need   Plumber", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Search location / name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { /* search */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Search")
                }
            }
        }

        // Tabs
        var tabIndex by remember { mutableStateOf(0) }
        TabRow(selectedTabIndex = tabIndex) {
            Tab(selected = tabIndex == 0, onClick = { tabIndex = 0 }) { Text("Favorites") }
            Tab(selected = tabIndex == 1, onClick = { tabIndex = 1 }) { Text("Orders") }
        }

        // Provider list
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(3) { idx ->
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("handyman07") },
                    leadingContent = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    headlineContent = { Text("Jessy Jones") },
                    supportingContent = { Text("Johannesburg") },
                    trailingContent = {
                        Column(horizontalAlignment = Alignment.End) {
                            Text("4.8 ★")
                            Text("500 m")
                            Text("$15/h")
                        }
                    }
                )
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman05Preview() {
    Handyman05(navController = rememberNavController())
}
