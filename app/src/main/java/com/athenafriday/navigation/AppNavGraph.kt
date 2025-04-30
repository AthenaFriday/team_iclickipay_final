package com.athenafriday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.chatcarlos.navigation.ChatNavHost
import com.athenafriday.handyman.navigation.HandymanNavHost
import com.athenafriday.learn.navigation.LearnNavHost
import com.athenafriday.screens.DashboardScreen
import com.athenafriday.tinderjerome.navigation.TinderNavHost

// Correct imports for each module's screen

//import com.athenafriday.chatCarlos.screens.ChatScreen
//import com.athenafriday.deliveryDonna.screens.DeliveryScreen
//import com.athenafriday.eatJack.screens.EatScreen
//import com.athenafriday.handymanSimadri.screens.HandymanScreen
import com.athenafriday.ibankjack.navigation.IbankNavGraph
//import com.athenafriday.learnSimadri.screens.LearnScreen
//import com.athenafriday.pcrepaircarlos.screens.PCRepairScreen
//import com.athenafriday.petDonna.screens.PetScreen
import com.athenafriday.tinderjerome.screens.TinderScreen
import com.athenafriday.uberjerome.navigation.UberNavHost
import com.athenafriday.uberjerome.screens.UberScreen

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
//        composable(Destinations.DELIVERY) { DeliveryScreen(navController) }
//        composable(Destinations.EAT) { EatScreen(navController) }
            composable(Destinations.HANDYMAN) { HandymanNavHost() }
            composable(Destinations.IBANK) { IbankNavGraph(navController) }
            composable(Destinations.LEARN) { LearnNavHost() }
//        composable(Destinations.PC_REPAIR) { PCRepairScreen(navController) }
//        composable(Destinations.PET) { PetScreen(navController) }
          composable(Destinations.TINDER) { TinderNavHost() }
          composable(Destinations.UBER) { UberNavHost() }

    }
}
