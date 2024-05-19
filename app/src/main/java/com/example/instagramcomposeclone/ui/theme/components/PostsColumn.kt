package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.example.instagramcomposeclone.model.Post
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun PostsColumn(posts: List<Post>, modifier: Modifier = Modifier) {
    LazyColumn (modifier = Modifier.fillMaxWidth()) {
        items(posts) { post ->
            Post(post)
        }
    }
}