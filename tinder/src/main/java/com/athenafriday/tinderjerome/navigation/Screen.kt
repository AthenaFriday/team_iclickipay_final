package com.athenafriday.tinderjerome.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object AddPhoto : Screen("add_photo")
    object TakePhoto : Screen("take_photo")
    object CompleteProfile : Screen("complete_profile")
    object Geolocation : Screen("geolocation")
    object Tutorial : Screen("tutorial")
    object Swipe : Screen("swipe")
    object ProfileDetails : Screen("profile_details")
    object Boost : Screen("boost")
    object Like : Screen("like")
    object SuperLike : Screen("super_like")
    object AccountSettings : Screen("account_settings")
}
