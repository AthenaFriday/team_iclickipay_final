package com.athenafriday.learn.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Learn07(navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Icon(Icons.Filled.Person, contentDescription = null, modifier = Modifier.size(80.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("Jenny Jones", style = MaterialTheme.typography.headlineSmall)
            Text("4.8 ★   \$15/h", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas.",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Column(Modifier.padding(horizontal = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.LocationOn, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("28 Broad Street, Johannesburg")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.MenuBook, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("English")
                Spacer(modifier = Modifier.width(16.dp))
                Text("French")
                Spacer(modifier = Modifier.width(16.dp))
                Text("Elementary")
                Spacer(modifier = Modifier.width(16.dp))
                Text("College")
            }
        }

        Spacer(modifier = Modifier.weight(1f))
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
fun Learn07Preview() {
    Learn07(navController = rememberNavController())
}
