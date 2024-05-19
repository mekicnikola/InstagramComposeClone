package com.example.instagramcomposeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.instagramcomposeclone.model.User
import com.example.instagramcomposeclone.navigation.BottomNavigationBar
import com.example.instagramcomposeclone.navigation.NavigationGraph
import com.example.instagramcomposeclone.ui.theme.InstagramComposeCloneTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val user = User(username = "peter_b_parker",
                profileImageResource = R.drawable.profile_photo,
            name = "Peter Parker",
            description = "Photographer | Daily Bugle",
            publications = 153,
            followers = 209,
            following = 109,
            notificationNumber = 9,
            )
            InstagramComposeCloneTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { innerPadding ->
                    NavigationGraph(navController = navController, modifier = Modifier.padding(innerPadding), user)
                }
            }
        }
    }
}
