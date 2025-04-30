package com.athenafriday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.athenafriday.iclickipay.R
import com.athenafriday.navigation.Destinations

data class AppItem(val label: String, val icon: Painter, val destination: String)

@Composable
fun DashboardScreen(navController: NavController) {
    val favorites = listOf(
//        AppItem("Eat", painterResource(id = R.drawable.eat), Destinations.EAT),
        AppItem("Tinder", painterResource(id = R.drawable.tinder), Destinations.TINDER),
        AppItem("Uber", painterResource(id = R.drawable.uber), Destinations.UBER),
        AppItem("iBank", painterResource(id = R.drawable.ibank), Destinations.IBANK),
        AppItem("Pet", painterResource(id = R.drawable.pet), Destinations.PET)
    )

    val others = listOf(
        AppItem("Chat", painterResource(id = R.drawable.chat), Destinations.CHAT),
        AppItem("Delivery", painterResource(id = R.drawable.delivery), Destinations.DELIVERY),
        AppItem("Learn", painterResource(id = R.drawable.learn), Destinations.LEARN),
        AppItem("Handyman", painterResource(id = R.drawable.handyman), Destinations.HANDYMAN),
        AppItem("PC Repair", painterResource(id = R.drawable.pc_repair), Destinations.PC_REPAIR)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Favorite Apps", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(favorites) { app ->
                DashboardItem(app) { navController.navigate(app.destination) }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Other Services", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(others) { app ->
                DashboardItem(app) { navController.navigate(app.destination) }
            }
        }
    }
}

@Composable
fun DashboardItem(app: AppItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(72.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = app.icon,
            contentDescription = app.label,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = app.label, fontSize = 12.sp)
    }
}
