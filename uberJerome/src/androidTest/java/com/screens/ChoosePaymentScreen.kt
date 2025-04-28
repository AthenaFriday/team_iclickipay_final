package com.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.navigation.UberDestinations

@Composable
fun ChoosePaymentScreen(navController: NavController) {
    var selectedOption by remember { mutableStateOf("Visa ****1234") }

    val paymentOptions = listOf("Visa ****1234", "MasterCard ****5678", "Cash")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Choose Payment Method",
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                paymentOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { selectedOption = text },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { selectedOption = text }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = text, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate(UberDestinations.DelayedTrip) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Confirm Payment")
            }
        }
    }
}
