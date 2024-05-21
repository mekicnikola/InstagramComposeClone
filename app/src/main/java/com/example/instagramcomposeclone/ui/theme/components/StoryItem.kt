package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramBlue
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.ui.theme.instagramGradient

@Preview
@Composable
fun StoryItem(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.profile_photo,
    userName: String = "username",
    isYourStory: Boolean = false
) {
    Column(
        modifier = modifier.padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .size(70.dp)
                .clickable { }
        ) {
            val painter = rememberAsyncImagePainter(model = imageResId)
            Image(
                painter = painter,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(
                        width = if (isYourStory) 0.dp else 3.dp,
                        brush = if (isYourStory) Brush.linearGradient(
                            listOf(Color.Gray, Color.Gray)
                        ) else instagramGradient,
                        shape = CircleShape
                    )
                    .background(colorScheme.secondary, shape = CircleShape),
                contentScale = ContentScale.Crop,
                contentDescription = "$userName's Story"
            )
            if (isYourStory) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .background(instagramBlue, shape = CircleShape)
                        .align(Alignment.BottomEnd),
                    painter = painterResource(id = R.drawable.plus_small),
                    contentDescription = "New Story",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.width(60.dp),
            text = userName,
            fontSize = 11.sp,
            color = colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}
