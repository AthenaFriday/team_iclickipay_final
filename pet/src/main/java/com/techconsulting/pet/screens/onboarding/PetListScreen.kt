package com.techconsulting.pet.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.pet.R

data class Pet(val name: String, val imageRes: Int)

@Composable
fun YourDogListScreen(
    petList: List<Pet> = listOf(
        Pet("Kobe", R.drawable.fake_photo)
    ),
    onAddNewClicked: () -> Unit = {},
    onEditClicked: (Pet) -> Unit = {},
    onDeleteClicked: (Pet) -> Unit = {},
    onNextClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF607D8B)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Your dog", style = MaterialTheme.typography.headlineSmall)
        }

        // New dog button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onAddNewClicked)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.new_pet),
                contentDescription = "Add new dog",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF4CAF50), shape = MaterialTheme.shapes.medium)
                    .padding(8.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("New dog", fontSize = 18.sp)
        }

        // List of dogs
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(petList) { pet ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = pet.imageRes),
                            contentDescription = pet.name,
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 8.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = pet.name,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        IconButton(onClick = { onEditClicked(pet) }) {
                            Icon(Icons.Default.Edit, contentDescription = "Edit")
                        }
                        IconButton(onClick = { onDeleteClicked(pet) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                    }
                }
            }
        }

        // Next button
        Button(
            onClick = onNextClicked,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F27))
        ) {
            Text("Next", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun YourDogListScreenPreview() {
    YourDogListScreen()
}

