package com.techconsulting.delivery.screens.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
@SuppressLint("MissingPermission")
fun DeliveryMapScreen(
    onAddressEntered: (String) -> Unit = {},
    onNextClicked: () -> Unit = {}
) {
    var address by remember { mutableStateOf(TextFieldValue("")) }

    val singapore = LatLng(1.3521, 103.8198) // default starting point
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 14f)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = address,
            onValueChange = {
                address = it
                onAddressEntered(it.text)
            },
            label = { Text("Enter your address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = singapore),
                    title = "Delivery Location",
                    snippet = "You are here"
                )
            }
        }

        Button(
            onClick = onNextClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F27))
        ) {
            Text("Confirm", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DeliveryMapScreenPreview() {
    DeliveryMapScreen()
}


