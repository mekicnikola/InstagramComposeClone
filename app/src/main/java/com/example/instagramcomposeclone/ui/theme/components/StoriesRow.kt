package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagramcomposeclone.R

data class Story(val id: Int, val imageResId: Int, val userName: String, val isYourStory: Boolean = false)

val storiesPlaceholder: List<Story> = listOf(
    Story(id = 1, imageResId = R.drawable.profile_photo, userName = "Your story", isYourStory = true),
    Story(id = 2, imageResId = R.drawable.harry_osborn, userName = "Harry Osborn"),
    Story(id = 3, imageResId = R.drawable.norman_osborn, userName = "Norman Osborn"),
    Story(id = 4, imageResId = R.drawable.otto_octavius, userName = "Otto Octavius"),
    Story(id = 5, imageResId = R.drawable.mary_jane, userName = "Mary Jane Watson"),
    Story(id = 6, imageResId = R.drawable.jonah_jameson, userName = "Jonah Jameson")
)

@Preview
@Composable
fun StoriesRow(modifier: Modifier = Modifier, stories: List<Story> = storiesPlaceholder) {
    val rememberedStories = remember { stories }

    LazyRow(
        state = remember { LazyListState() },
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Left
    ) {
        items(rememberedStories, key = { it.id }) { story ->
            StoryItem(
                imageResId = story.imageResId,
                userName = story.userName,
                isYourStory = story.isYourStory,
                modifier = Modifier
            )
        }
    }
}
