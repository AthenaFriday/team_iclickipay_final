package com.athenafriday.handyman.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman02(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        // Header with name + month selector
        Text("Jenny Jones", style = MaterialTheme.typography.headlineSmall)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(selectedDate.month.name, fontWeight = FontWeight.Bold)
            IconButton(onClick = { /*next month*/ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Next") // rotate 180 for forward
            }
        }
        // Weekday header
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            DayOfWeek.values().forEach { day ->
                Text(day.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
            }
        }
        // Dates row
        LazyRow(Modifier.padding(vertical = 8.dp)) {
            items(14) { index ->
                val date = LocalDate.now().plusDays(index.toLong())
                val isSelected = date == selectedDate
                Box(
                    Modifier
                        .size(40.dp)
                        .padding(4.dp)
                        .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent, shape = MaterialTheme.shapes.small)
                        .clickable { selectedDate = date },
                    contentAlignment = Alignment.Center
                ) {
                    Text("${date.dayOfMonth}")
                }
            }
        }
        Divider()
        // Time slots
        LazyColumn {
            items(listOf("01:00 PM","01:30 PM","02:00 PM","02:30 PM","03:00 PM","03:30 PM","04:00 PM")) { time ->
                Text(
                    time,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .clickable { /* select time */ }
                )
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman02Preview() {
    Handyman02(navController = rememberNavController())
}