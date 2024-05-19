package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

data class Story(val imageResId: Int, val userName: String, val isYourStory: Boolean = false)
@Composable
fun StoriesRow(stories: List<Story>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Left
    ) {
        items(stories) { story ->
            StoryItem(
                imagePainter = painterResource(id = story.imageResId),
                userName = story.userName,
                isYourStory = story.isYourStory,
                modifier = Modifier
            )
        }
    }
}