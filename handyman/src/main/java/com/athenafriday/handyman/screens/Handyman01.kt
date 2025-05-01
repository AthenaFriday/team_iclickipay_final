package com.athenafriday.handyman.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

private val Orange500 = Color(0xFFF77E1B)
private val DarkText   = Color(0xFF1F1F1F)
private val GrayText   = Color(0xFF9E9E9E)
private val BorderGray = Color(0xFFCCCCCC)

@Composable
fun DropDownField(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Text(label, color = GrayText, fontSize = 14.sp)
        Spacer(Modifier.height(4.dp))
        Surface(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, BorderGray),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { expanded = true }
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment   = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(selectedOption, color = DarkText)
                Icon(
                    imageVector    = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint           = GrayText
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text    = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ThinSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    steps: Int,
    thumbRadius: Dp = 8.dp,
    trackThickness: Dp = 1.dp,
    activeColor: Color = Orange500,
    inactiveColor: Color = BorderGray,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    var widthPx by remember { mutableStateOf(0f) }
    val thumbPx = with(density) { thumbRadius.toPx() }
    val trackPx = with(density) { trackThickness.toPx() }

    Canvas(modifier
        .fillMaxWidth()
        .height(thumbRadius * 2)
        .onSizeChanged { widthPx = it.width.toFloat() }
        .pointerInput(value) {
            detectDragGestures { change, _ ->
                change.consume()
                val x = change.position.x.coerceIn(0f, widthPx)
                val newValue = valueRange.start +
                        (x / widthPx) * (valueRange.endInclusive - valueRange.start)
                onValueChange(newValue)
            }
        }
    ) {
        val centerY = size.height / 2f
        // Inactive track
        drawLine(
            color = inactiveColor,
            start = Offset(0f, centerY),
            end   = Offset(size.width, centerY),
            strokeWidth = trackPx
        )
        // Active track
        val fraction = (value - valueRange.start) / (valueRange.endInclusive - valueRange.start)
        val thumbX = fraction * size.width
        drawLine(
            color = activeColor,
            start = Offset(0f, centerY),
            end   = Offset(thumbX, centerY),
            strokeWidth = trackPx
        )
        // Thumb outer circle
        drawCircle(
            color  = activeColor,
            radius = thumbPx,
            center = Offset(thumbX, centerY)
        )
        // Thumb inner circle
        drawCircle(
            color  = Color.White,
            radius = thumbPx * 0.6f,
            center = Offset(thumbX, centerY)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Handyman01(navController: NavController) {
    val needOptions    = listOf("Plumber", "Electrician", "Carpenter", "Painter")
    val problemOptions = listOf("Do not work", "Leaks", "Installation", "Maintenance")
    val hourMarks      = listOf(8, 11, 14, 17, 20)

    var selectedNeed    by remember { mutableStateOf(needOptions[0]) }
    var selectedProblem by remember { mutableStateOf(problemOptions[0]) }
    var availability    by remember { mutableStateOf(14f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Your handyman",
                        color      = DarkText,
                        fontSize   = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign  = TextAlign.Center,
                        modifier   = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("handyman00") }) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Back to intro",
                            tint = Orange500
                        )
                    }
                },
                colors    = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
            )
        },
        containerColor = Color.White
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))

            DropDownField(
                label            = "Need",
                options          = needOptions,
                selectedOption   = selectedNeed,
                onOptionSelected = { selectedNeed = it }
            )

            Spacer(Modifier.height(16.dp))

            DropDownField(
                label            = "Problem",
                options          = problemOptions,
                selectedOption   = selectedProblem,
                onOptionSelected = { selectedProblem = it }
            )

            Spacer(Modifier.height(30.dp))

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Availability",
                    color      = GrayText,
                    fontSize   = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.width(8.dp))
                Spacer(Modifier.height(50.dp))
                Divider(
                    modifier  = Modifier.weight(1f),
                    color     = BorderGray,
                    thickness = 1.dp
                )
            }

            ThinSlider(
                value       = availability,
                onValueChange = { availability = it },
                valueRange  = 8f..20f,
                steps       = hourMarks.size - 2,
                thumbRadius = 8.dp,
                trackThickness = 1.dp
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                hourMarks.forEach { hr ->
                    val isSelected = (hr.toFloat() == availability)
                    Text(
                        "${hr}h",
                        color      = if (isSelected) DarkText else GrayText,
                        fontSize   = if (isSelected) 16.sp else 14.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick   = { navController.navigate("handyman02") },
                shape     = RoundedCornerShape(8.dp),
                colors    = ButtonDefaults.buttonColors(containerColor = Orange500),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                modifier  = Modifier
                    .width(250.dp)
                    .height(56.dp)
            ) {
                Text(
                    "Next",
                    color      = Color.White,
                    fontSize   = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Handyman01Preview() {
    Handyman01(navController = rememberNavController())
}
