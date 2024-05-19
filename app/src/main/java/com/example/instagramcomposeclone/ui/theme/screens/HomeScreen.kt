package com.example.instagramcomposeclone.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.model.Post
import com.example.instagramcomposeclone.ui.theme.components.PostsColumn
import com.example.instagramcomposeclone.ui.theme.components.StoriesRow
import com.example.instagramcomposeclone.ui.theme.components.Story

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val stories = listOf(
        Story(imageResId = R.drawable.profile_photo, userName = "Your story", isYourStory = true),
        Story(imageResId = R.drawable.harry_osborn, userName = "Harry Osborn"),
        Story(imageResId = R.drawable.norman_osborn, userName = "Norman Osborn"),
        Story(imageResId = R.drawable.otto_octavius, userName = "Otto Octavius"),
        Story(imageResId = R.drawable.mary_jane, userName = "Mary Jane Watson"),
        Story(imageResId = R.drawable.jonah_jameson, userName = "Jonah Jameson")
    )

    val post1 = Post(
        username = "norman_osborn",
        userImage = R.drawable.norman_osborn,
        postImage = R.drawable.norman_osborn_experiment,
        postDescription = "Everything is prepared for this new experiment. I hope everything goes well.",
        postDate = "1. june, 2002.",
        firstLike = "osborn_jr",
        likesNumber = 535,
        firstImage = R.drawable.harry_osborn,
        secondImage = R.drawable.otto_octavius,
        thirdImage = R.drawable.jonah_jameson)

    val post2 = Post(
        username = "otto_octavius",
        userImage = R.drawable.otto_octavius,
        postImage = R.drawable.otto_octavius_experiment,
        postDescription = "Everything is prepared for my new experiment. I hope everything goes well.",
        postDate = "26. january, 2004.",
        firstLike = "jameson123",
        likesNumber = 77,
        firstImage = R.drawable.jonah_jameson,
        secondImage = R.drawable.harry_osborn,
        thirdImage = R.drawable.mary_jane)

    val posts = mutableListOf(post1, post2)

    Scaffold(
        topBar = { TopHomeNavigation() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorScheme.background)
        ) {
            StoriesRow(stories = stories)
            PostsColumn(posts = posts)
        }
    }
}

@Composable
fun TopHomeNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .background(colorScheme.background)
        ,
        horizontalArrangement = Arrangement.End) {
        Button(
            modifier = Modifier.size(24.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.plus_small_border),
                contentDescription = "New post",
                tint = colorScheme.onBackground
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            modifier = Modifier.size(24.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "New post",
                tint = colorScheme.onBackground
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            modifier = Modifier.size(24.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.messenger),
                contentDescription = "New post",
                tint = colorScheme.onBackground
            )
        }
    }
}




