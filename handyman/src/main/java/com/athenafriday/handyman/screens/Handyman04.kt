package com.athenafriday.handyman.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman04(navController: NavController) {

    // State variables
    var sortBy by remember { mutableStateOf("Recommend") }
    var priceRange by remember { mutableStateOf(30f) }
    var rating by remember { mutableStateOf(4) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Spacer(Modifier.height(24.dp))

        Text("Filters", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))

        // Sort by
        Text("Sort by", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        Spacer(Modifier.height(8.dp))
        SortByDropdown(selectedOption = sortBy, onOptionSelected = { sortBy = it })
        Spacer(Modifier.height(24.dp))

        // Price/hour
        Text("Price/hour", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        Spacer(Modifier.height(8.dp))
        PricePerHourSlider(value = priceRange, onValueChange = { priceRange = it })
        Spacer(Modifier.height(8.dp))

        // Rate
        Text("Rate", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
        Spacer(Modifier.height(8.dp))
        RatingStars(selectedRating = rating, onRatingSelected = { rating = it })

        Spacer(Modifier.weight(1f)) // Push button to bottom

        // Apply Button
        Button(
            onClick = { navController.navigate("handyman02") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7941D)), // Orange
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Apply", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun SortByDropdown(selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Recommend", "Price", "Rating")

    Box {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                Icon(
                    Icons.Default.ArrowBack, // Reversed arrow
                    contentDescription = "Dropdown",
                    tint = Color.Gray
                )
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = { onOptionSelected(option) }, text = { Text(option) })
            }
        }

        Modifier.clickable { expanded = !expanded }
    }
}

@Composable
fun PricePerHourSlider(value: Float, onValueChange: (Float) -> Unit) {
    Column {
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..60f,
            steps = 2,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                activeTrackColor = Color(0xFFF7941D),
                thumbColor = Color(0xFFF7941D)
            )
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("0", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Text("30", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Text("60", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
        }
    }
}

@Composable
fun RatingStars(selectedRating: Int, onRatingSelected: (Int) -> Unit) {
    Row {
        (1..5).forEach { i ->
            IconButton(onClick = { onRatingSelected(i) }) {
                Icon(
                    imageVector = if (i <= selectedRating) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = null,
                    tint = Color(0xFFF7941D) // Orange
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman04Preview() {
    Handyman04(navController = rememberNavController())
}