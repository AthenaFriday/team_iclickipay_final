package com.athenafriday.learn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@Composable
fun Learn03(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
        Text("Jenny Jones", style = MaterialTheme.typography.headlineSmall)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(selectedDate.month.name, fontWeight = FontWeight.Bold)
            IconButton(onClick = { /* next month */ }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Next",
                    modifier = Modifier.graphicsLayer(rotationZ = 180f)
                )
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            DayOfWeek.values().forEach {
                Text(it.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
            }
        }
        LazyRow(Modifier.padding(vertical = 8.dp)) {
            items(14) { i ->
                val date = LocalDate.now().plusDays(i.toLong())
                val isSelected = date == selectedDate
                Box(
                    Modifier
                        .size(40.dp)
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                            shape = MaterialTheme.shapes.small
                        )
                        .clickable { selectedDate = date },
                    contentAlignment = Alignment.Center
                ) {
                    Text("${date.dayOfMonth}")
                }
            }
        }
        Divider()
        LazyColumn {
            items(listOf("01:00 PM","01:30 PM","02:00 PM","02:30 PM","03:00 PM","03:30 PM")) { time ->
                Text(
                    time,
                    Modifier
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
fun Learn03Preview() {
    Learn03(navController = rememberNavController())
}
