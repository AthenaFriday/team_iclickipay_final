package com.athenafriday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.chatcarlos.navigation.ChatNavHost
import com.athenafriday.handyman.navigation.HandymanNavHost
import com.athenafriday.ibankjack.navigation.IbankNavGraph
import com.athenafriday.learn.navigation.LearnNavHost
import com.athenafriday.pet.navigation.PetNavHost
import com.athenafriday.screens.DashboardScreen
import com.athenafriday.tinderjerome.navigation.TinderNavHost
import com.athenafriday.uberjerome.navigation.UberNavHost

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
        composable(Destinations.CHAT) { ChatNavHost() }
        // composable(Destinations.DELIVERY) { DeliveryScreen(navController) }
        // composable(Destinations.EAT) { EatScreen(navController) }
        composable(Destinations.HANDYMAN) { HandymanNavHost() }
        composable(Destinations.IBANK) { IbankNavGraph() }  // Pass navController here
        composable(Destinations.LEARN) { LearnNavHost() }
        // composable(Destinations.PC_REPAIR) { PCRepairScreen(navController) }
        composable(Destinations.PET) { PetNavHost() }
        composable(Destinations.TINDER) { TinderNavHost() }
        composable(Destinations.UBER) { UberNavHost() }
    }
}
