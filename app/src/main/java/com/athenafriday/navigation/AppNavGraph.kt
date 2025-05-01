package com.athenafriday.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athenafriday.chatcarlos.navigation.ChatNavHost
import com.athenafriday.handyman.navigation.HandymanNavHost
import com.athenafriday.ibankjack.navigation.IbankNavGraph
import com.athenafriday.learn.navigation.LearnNavHost
import com.athenafriday.pet.navigation.PetNavHost
import com.athenafriday.screens.DashboardScreen
import com.athenafriday.screens.authentication.login.LoginScreen
import com.athenafriday.screens.authentication.signup.SignupScreen
import com.athenafriday.tinderjerome.navigation.TinderNavHost
import com.athenafriday.uberjerome.navigation.UberNavHost

object Destinations {
    const val LOGIN = "login"
    const val SIGNUP = "signup"
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
    NavHost(navController = navController, startDestination = Destinations.LOGIN) {

        // ✅ Login screen navigates to dashboard on successful login
        composable(Destinations.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Destinations.DASHBOARD) {
                        popUpTo(Destinations.LOGIN) { inclusive = true }
                    }
                },
                onSignupClick = {
                    navController.navigate(Destinations.SIGNUP)
                }
            )
        }

        // ✅ Signup screen navigates to dashboard on successful signup
        composable(Destinations.SIGNUP) {
            SignupScreen(
                modifier = Modifier,
                onSignupSuccess = {
                    navController.navigate(Destinations.DASHBOARD) {
                        popUpTo(Destinations.SIGNUP) { inclusive = true }
                    }
                }
            )
        }

        composable(Destinations.DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(Destinations.CHAT) { ChatNavHost() }
//      composable(Destinations.DELIVERY) { DeliveryNavHost(navController) }
//      composable(Destinations.EAT) { EatNavHost(navController) }
        composable(Destinations.HANDYMAN) { HandymanNavHost() }
        composable(Destinations.IBANK) { IbankNavGraph() }
        composable(Destinations.LEARN) { LearnNavHost() }
//      composable(Destinations.PC_REPAIR) { PCRepairNavHost(navController) }
        composable(Destinations.PET) { PetNavHost() }
        composable(Destinations.TINDER) { TinderNavHost() }
        composable(Destinations.UBER) { UberNavHost() }
    }
}
