package com.example.instagramcomposeclone.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instagramcomposeclone.R
import androidx.compose.material3.MaterialTheme.colorScheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Reels,
        BottomNavItem.Shopping,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(modifier = Modifier.background(colorScheme.background)) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    if (item == BottomNavItem.Profile) {
                        Image(
                            painter = painterResource(id = if (currentRoute == item.route) R.drawable.profile_photo else R.drawable.profile_photo),
                            contentDescription = item.label,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = when (item) {
                                BottomNavItem.Home -> if (currentRoute == item.route) R.drawable.home_filled else R.drawable.home
                                BottomNavItem.Explore -> if (currentRoute == item.route) R.drawable.search_filled else R.drawable.search
                                BottomNavItem.Reels -> if (currentRoute == item.route) R.drawable.reels_filled else R.drawable.reels
                                BottomNavItem.Shopping -> if (currentRoute == item.route) R.drawable.shopping_filled else R.drawable.shopping
                                BottomNavItem.Profile -> R.drawable.profile_photo
                            }),
                            contentDescription = item.label,
                            tint = if (currentRoute == item.route) colorScheme.onBackground else colorScheme.onBackground
                        )
                    }
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.onBackground,
                    unselectedIconColor = colorScheme.onBackground,
                    indicatorColor = colorScheme.background,
                )
            )
        }
    }
}