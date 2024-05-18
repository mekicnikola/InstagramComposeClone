package com.example.instagramcomposeclone.navigation

sealed class BottomNavItem(val route: String, val label: String) {
    object Home : BottomNavItem("home", "Home")
    object Explore : BottomNavItem("explore", "Explore")

    object Reels : BottomNavItem("reels", "Reels")

    object Shopping : BottomNavItem("shopping", "Shopping")
    object Profile : BottomNavItem("profile", "Profile")
}