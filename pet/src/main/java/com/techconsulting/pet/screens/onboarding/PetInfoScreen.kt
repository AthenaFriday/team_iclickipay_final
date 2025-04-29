package com.techconsulting.pet.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athenafriday.pet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetInfoScreen(onNextClicked: () -> Unit = {}) {
    var name by remember { mutableStateOf("") }
    var selectedBreed by remember { mutableStateOf("Pug") }
    var isMale by remember { mutableStateOf(true) }
    var selectedAge by remember { mutableStateOf("10") }
    var size by remember { mutableStateOf(1f) } // 0 = Small, 1 = Middle, 2 = Big

    val breeds = listOf("Pug", "Mix", "Shepperd", "Pitbull", "Staffy")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top bar
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

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Race", fontSize = 14.sp, color = Color.Gray)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            breeds.forEach { breed ->
                FilterChip(
                    selected = selectedBreed == breed,
                    onClick = { selectedBreed = breed },
                    label = { Text(breed) }
                )
            }
        }

        Text("Sex", fontSize = 14.sp, color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isMale,
                onCheckedChange = { isMale = true }
            )
            Text("Male")
            Spacer(modifier = Modifier.width(16.dp))
            Checkbox(
                checked = !isMale,
                onCheckedChange = { isMale = false }
            )
            Text("Female")
        }

        Text("Age", fontSize = 14.sp, color = Color.Gray)
        ExposedDropdownMenuBox(
            expanded = false, // you can wire this up for full dropdown
            onExpandedChange = {}
        ) {
            OutlinedTextField(
                value = selectedAge,
                onValueChange = { selectedAge = it },
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Age") }
            )
        }

        Text("Size", fontSize = 14.sp, color = Color.Gray)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Slider(
                value = size,
                onValueChange = { size = it },
                valueRange = 0f..2f,
                steps = 1,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Small")
                Text("Middle")
                Text("Big")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

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
fun PetInfoScreenPreview() {
    PetInfoScreen()
}
