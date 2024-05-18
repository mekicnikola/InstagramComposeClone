package com.example.instagramcomposeclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagramcomposeclone.ui.theme.screens.ExploreScreen
import com.example.instagramcomposeclone.ui.theme.screens.HomeScreen
import com.example.instagramcomposeclone.ui.theme.screens.ProfileScreen
import com.example.instagramcomposeclone.ui.theme.screens.ReelsScreen
import com.example.instagramcomposeclone.ui.theme.screens.ShoppingScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Home.route, modifier = modifier) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Explore.route) {
            ExploreScreen()
        }
        composable(BottomNavItem.Reels.route) {
            ReelsScreen()
        }
        composable(BottomNavItem.Shopping.route) {
            ShoppingScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen(username = "peter_b_parker")
        }
    }
}