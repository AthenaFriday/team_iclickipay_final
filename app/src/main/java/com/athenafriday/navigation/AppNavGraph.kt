// FILE: AppNavGraph.kt
package com.athenafriday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.screens.DashboardScreen
import com.athenafriday.chat.ChatMainScreen
import com.athenafriday.delivery.DeliveryMainScreen
import com.athenafriday.eat.EatMainScreen
import com.athenafriday.handyman.HandymanMainScreen
import com.athenafriday.ibank.IbankMainScreen
import com.athenafriday.learn.LearnMainScreen
import com.athenafriday.pc_repair.PcRepairMainScreen
import com.athenafriday.pet.PetMainScreen
import com.athenafriday.tinder.TinderMainScreen
import com.athenafriday.uber.UberMainScreen

object Destinations {
    const val DASHBOARD = "dashboard"
    const val CHAT = "chat"
    const val DELIVERY = "delivery"
    const val EAT = "eat"
    const val HANDYMAN = "handyman"
    const val IBANK = "ibank"
    const val LEARN = "learn"
    const val PC_REPAIR = "pc_repair"
    const val PET = "pet"
    const val TINDER = "tinder"
    const val UBER = "uber"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.DASHBOARD) {
        composable(Destinations.DASHBOARD) { DashboardScreen(navController) }
        composable(Destinations.CHAT) { ChatMainScreen() }
        composable(Destinations.DELIVERY) { DeliveryMainScreen() }
        composable(Destinations.EAT) { EatMainScreen() }
        composable(Destinations.HANDYMAN) { HandymanMainScreen() }
        composable(Destinations.IBANK) { IbankMainScreen() }
        composable(Destinations.LEARN) { LearnMainScreen() }
        composable(Destinations.PC_REPAIR) { PcRepairMainScreen() }
        composable(Destinations.PET) { PetMainScreen() }
        composable(Destinations.TINDER) { TinderMainScreen() }
        composable(Destinations.UBER) { UberMainScreen() }
    }
}
