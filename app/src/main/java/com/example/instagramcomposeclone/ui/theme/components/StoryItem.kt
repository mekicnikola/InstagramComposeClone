package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramBlue
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.ui.theme.instagramGradient

@Preview
@Composable
fun StoryItem(
    modifier: Modifier = Modifier,
    imagePainter: Painter = painterResource(id = R.drawable.profile_photo),
    userName: String = "username",
    isYourStory: Boolean = false
) {
    Column(
        modifier = modifier.padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = modifier.size(60.dp),
        ) {
            Image(
                painter = imagePainter,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(colorScheme.secondary, shape = CircleShape)
                    .border(
                        width = if(isYourStory) 0.dp else 2.dp,
                        brush = if (isYourStory) Brush.linearGradient(
                            listOf(Color.Gray, Color.Gray)
                        ) else instagramGradient,
                        shape = CircleShape
                    ),
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
            text = userName,
            fontSize = 11.sp,
            color = colorScheme.onBackground
        )
    }
}