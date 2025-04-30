package com.athenafriday.handyman.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman07(navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Spacer(Modifier.height(24.dp))
        // Profile pic + name + rating + rate
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(80.dp))
            Spacer(Modifier.height(8.dp))
            Text("Jenny Jones", style = MaterialTheme.typography.headlineSmall)
            Text("4.8 ★   \$15/h", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(16.dp))
            Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas.",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
        Spacer(Modifier.height(24.dp))

        // Location & skills
        Column(Modifier.padding(horizontal = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("28 Broad Street, Johannesburg")
            }
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Build, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Plumber")
                Spacer(Modifier.width(16.dp))
                Text("Carpenter")
            }
        }
        Spacer(Modifier.weight(1f))

        Button(
            onClick = { /* take appointment */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(16.dp)
        ) {
            Text("Take appointment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman07Preview() {
    Handyman07(navController = rememberNavController())
}