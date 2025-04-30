package com.techconsulting.delivery.screens.onboarding


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParcelInfoScreen(
    onNextClicked: () -> Unit = {}
) {
    var weight by remember { mutableStateOf(5f) }
    var height by remember { mutableStateOf(50f) }
    var width by remember { mutableStateOf(50f) }
    var depth by remember { mutableStateOf(50f) }
    var isBrittle by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Your parcel", style = MaterialTheme.typography.headlineSmall)

        SliderWithLabel("Weight/kg", weight, 0f, 10f) { weight = it }
        SliderWithLabel("Height/cm", height, 0f, 100f) { height = it }
        SliderWithLabel("Width/cm", width, 0f, 100f) { width = it }
        SliderWithLabel("Depth/cm", depth, 0f, 100f) { depth = it }

        Text("Brittle", fontSize = 16.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isBrittle,
                onCheckedChange = { isBrittle = true },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFF7F27))
            )
            Text("Yes")
            Spacer(modifier = Modifier.width(16.dp))
            Checkbox(
                checked = !isBrittle,
                onCheckedChange = { isBrittle = false },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFF7F27))
            )
            Text("No")
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

@Composable
fun SliderWithLabel(label: String, value: Float, rangeStart: Float, rangeEnd: Float, onValueChange: (Float) -> Unit) {
    Column {
        Text("$label: ${value.toInt()}", fontSize = 14.sp)
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = rangeStart..rangeEnd,
            colors = SliderDefaults.colors(thumbColor = Color(0xFFFF7F27), activeTrackColor = Color(0xFFFF7F27))
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ParcelInfoScreenPreview() {
    ParcelInfoScreen(onNextClicked = {})
}

