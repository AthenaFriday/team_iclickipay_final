package com.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.navigation.UberNavHost
import com.navigation.UberDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UberHomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Uber Dashboard") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(uberScreens) { screen ->
                    Button(
                        onClick = { navController.navigate(screen.route) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = screen.label)
                    }
                }
            }
        }

        // 👇 This hosts the real screens inside the navController
        UberNavHost(navController = navController)
    }
}

data class UberScreenItem(
    val label: String,
    val route: String
)

val uberScreens = listOf(
    UberScreenItem("Set Destination", UberDestinations.SetDestination),
    UberScreenItem("Set Pickup", UberDestinations.SetPickup),
    UberScreenItem("Enter Location", UberDestinations.EnterLocation),
    UberScreenItem("Select Car", UberDestinations.SelectCar),
    UberScreenItem("Car Arriving", UberDestinations.CarArriving),
    UberScreenItem("Trip In Progress", UberDestinations.TripInProgress),
    UberScreenItem("Trip Complete", UberDestinations.TripComplete),
    UberScreenItem("Rate Driver", UberDestinations.RateDriver),
    UberScreenItem("Choose Payment", UberDestinations.ChoosePayment),
    UberScreenItem("Delayed Trip", UberDestinations.DelayedTrip),
    UberScreenItem("Custom Location", UberDestinations.CustomLocation)
)
