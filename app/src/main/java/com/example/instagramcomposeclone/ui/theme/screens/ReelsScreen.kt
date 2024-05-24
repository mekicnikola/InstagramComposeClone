package com.example.instagramcomposeclone.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.model.Reel
import com.example.instagramcomposeclone.model.heartEmoji
import com.example.instagramcomposeclone.model.sunsetEmoji
import com.example.instagramcomposeclone.model.waterDropEmoji
import com.example.instagramcomposeclone.model.waterWaveEmoji
import com.example.instagramcomposeclone.ui.theme.components.Reel


@Preview
@Composable
fun ReelsScreen() {
    val context = LocalContext.current



    val reels = listOf(
        Reel(
            id = 1,
            username = "mj_watson",
            userImage = R.drawable.mary_jane,
            description = "Ocean $waterWaveEmoji $waterDropEmoji",
            firstLike = "norman_osborn",
            likesNumber = 303,
            videoUrl = "https://www.shutterstock.com/shutterstock/videos/3479373475/preview/stock-footage-flying-over-the-quite-and-calm-deep-blue-sea-seascape-surigao-del-sur-mindanao-philippines.webm"
        ),
        Reel(
            id = 2,
            username = "osborn_jr",
            userImage = R.drawable.harry_osborn,
            description = "New York City $heartEmoji",
            firstLike = "mj_watson",
            likesNumber = 149,
            videoUrl = "https://www.shutterstock.com/shutterstock/videos/3478161737/preview/stock-footage-new-york-usa-august-stunning-new-york-at-night-scenery-eye-catching-sight-of-vibrant.webm"
        ),
        Reel(
            id = 3,
            username = "gwen_stacy",
            userImage = R.drawable.gwen_stacy,
            description = "Sunset $sunsetEmoji",
            firstLike = "edward_brock",
            likesNumber = 747,
            videoUrl = "https://www.shutterstock.com/shutterstock/videos/3502579413/preview/stock-footage-sun-rising-above-the-ocean-vertical-video.webm"
        )
    )


    val rememberReels = remember { reels }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp - 100

    Box {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()) {
            items(rememberReels, key = {it.id}){ reel ->
                Reel(modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight.dp), reel = reel, context = context)
            }
        }
        TopReelNavigation()
    }



}

@Composable
fun TopReelNavigation() {
    Row(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = "Reels",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { },
            painter = painterResource(id = R.drawable.camera),
            contentDescription = "Menu",
            tint = Color.White
        )
    }
}
