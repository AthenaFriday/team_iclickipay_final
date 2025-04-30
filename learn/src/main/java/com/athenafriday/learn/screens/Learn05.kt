package com.athenafriday.learn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.athenafriday.learn.R
import androidx.compose.material3.CardDefaults

@Composable
fun Learn05(navController: NavController) {
    Column {
        Box {
            Image(
                painter = painterResource(R.drawable.learn_header),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(onClick = { /* go home */ }, modifier = Modifier.padding(16.dp)) {
                Icon(Icons.Filled.Home, contentDescription = "Home")
            }
        }

        Spacer(modifier = Modifier.height(-40.dp))

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
                Text("Lesson  English", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Search location / name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { /* search */ }, modifier = Modifier.fillMaxWidth()) {
                    Text("Search")
                }
            }
        }

        var tabIndex by remember { mutableStateOf(0) }
        androidx.compose.material3.TabRow(selectedTabIndex = tabIndex) {
            androidx.compose.material3.Tab(selected = tabIndex == 0, onClick = { tabIndex = 0 }) { Text("Favorites") }
            androidx.compose.material3.Tab(selected = tabIndex == 1, onClick = { tabIndex = 1 }) { Text("Orders") }
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(listOf("Jessy Jones", "Christine Down")) { name ->
                androidx.compose.material3.ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("learn07") },
                    headlineContent = { Text(name) },
                    supportingContent = { Text("Johannesburg") },
                    leadingContent = {
                        Image(
                            painter = painterResource(R.drawable.teacher_jessy),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                    },
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
fun Learn05Preview() {
    Learn05(navController = rememberNavController())
}
