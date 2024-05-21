package com.example.instagramcomposeclone.ui.theme.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.model.Post
import com.example.instagramcomposeclone.ui.theme.components.Post
import com.example.instagramcomposeclone.ui.theme.components.StoriesRow
import com.example.instagramcomposeclone.ui.theme.components.Story

@Composable
fun HomeScreen() {

    val stories: List<Story> = listOf(
        Story(id = 1, imageResId = R.drawable.profile_photo, userName = "Your story", isYourStory = true),
        Story(id = 2, imageResId = R.drawable.harry_osborn, userName = "Harry Osborn"),
        Story(id = 3, imageResId = R.drawable.norman_osborn, userName = "Norman Osborn"),
        Story(id = 4, imageResId = R.drawable.otto_octavius, userName = "Otto Octavius"),
        Story(id = 5, imageResId = R.drawable.mary_jane, userName = "Mary Jane Watson"),
        Story(id = 6, imageResId = R.drawable.jonah_jameson, userName = "Jonah Jameson")
    )

    val posts = listOf(
        Post(
            id = 1,
            username = "norman_osborn",
            userImage = R.drawable.norman_osborn,
            postImage = R.drawable.norman_osborn_experiment,
            postDescription = "Everything is prepared for this new experiment. I hope everything goes well.",
            postDate = "1. june, 2002.",
            firstLike = "osborn_jr",
            likesNumber = 535,
            firstImage = R.drawable.harry_osborn,
            secondImage = R.drawable.otto_octavius,
            thirdImage = R.drawable.jonah_jameson
        ),
        Post(
            id = 2,
            username = "otto_octavius",
            userImage = R.drawable.otto_octavius,
            postImage = R.drawable.otto_octavius_experiment,
            postDescription = "Everything is prepared for my new experiment. I hope everything goes well.",
            postDate = "26. january, 2004.",
            firstLike = "jameson123",
            likesNumber = 77,
            firstImage = R.drawable.jonah_jameson,
            secondImage = R.drawable.harry_osborn,
            thirdImage = R.drawable.mary_jane
        ),
        Post(
            id = 3,
            username = "jameson123",
            userImage = R.drawable.jonah_jameson,
            postImage = R.drawable.jonah_jameson_papers,
            postDescription = "THIEF!",
            postDate = "14. may, 2007.",
            firstLike = "jameson123",
            likesNumber = 12,
            firstImage = R.drawable.jonah_jameson,
            secondImage = R.drawable.harry_osborn,
            thirdImage = R.drawable.profile_photo
        )
    )
    val rememberPosts = remember {posts}

    var topBarOffset by remember { mutableFloatStateOf(0f) }
    val animatedTopBarOffset by animateFloatAsState(
        targetValue = topBarOffset, label = ""
    )

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffset + delta
                topBarOffset = newOffset.coerceIn(-100f, 0f)
                return Offset.Zero
            }
        }
    }

    Scaffold(
        topBar = {
            TopHomeNavigation(modifier = Modifier.offset(y = animatedTopBarOffset.dp))
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)) {
            LazyColumn(
                state = remember { LazyListState() },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(colorScheme.background)
            ) {
                item {
                    StoriesRow(stories = stories)
                }
                items(rememberPosts, key = {it.id}) { post ->
                    Post(post)
                }
            }
        }
    }
}

@Composable
fun TopHomeNavigation(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
            .background(colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .height(38.dp),
            painter = painterResource(id = R.drawable.instagram_wordmark_logo),
            contentDescription = "logo",
            tint = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .size(28.dp)
                .clickable { },
            painter = painterResource(id = R.drawable.plus_small_border),
            contentDescription = "New post",
            tint = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            modifier = Modifier
                .size(28.dp)
                .clickable { },
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "New post",
            tint = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { },
            painter = painterResource(id = R.drawable.messenger),
            contentDescription = "New post",
            tint = colorScheme.onBackground
        )
    }
}
