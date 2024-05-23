package com.example.instagramcomposeclone.ui.theme.screens

import android.content.Context
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.rememberAsyncImagePainter
import com.example.instagramcomposeclone.R


@Preview
@Composable
fun ReelsScreen(
    modifier: Modifier = Modifier,
    videoUrl: String = "https://www.shutterstock.com/shutterstock/videos/3464864831/preview/stock-footage-sunset-view-at-the-beach-in-koh-kood-thailand.webm",
) {
    val context = LocalContext.current

    Box {



        ExoPlayerVideoPlayer(
            context = context,
            videoUrl = videoUrl,
            modifier = modifier.fillMaxSize()
        )


        Column(modifier = Modifier.fillMaxSize()){
            TopReelsNavigation()
            Spacer(modifier = Modifier.weight(1f))
            BottomReelsNavigation(
                userImage = R.drawable.mary_jane,
                username = "mj_watson",
                description = "Sunset",
                firstLike = "norman_osborn",
                likesNumber = 303
            )
        }



    }

}

@Composable
fun BottomReelsNavigation(userImage: Int, username: String, description: String, firstLike: String, likesNumber: Int) {
    val userImagePainter = rememberAsyncImagePainter(model = userImage)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)) {

        Column {
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape),
                    painter = userImagePainter,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = username,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                color = Color.White,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            ReelLikesText(firstLike = firstLike, likesNumber = likesNumber)
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(12.dp),
                    painter = painterResource(id = R.drawable.music),
                    contentDescription = "music",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Music Playing", color = Color.White, fontSize = 13.sp)
            }


        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Like",
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.comment),
                contentDescription = "Like",
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.paper_plane),
                contentDescription = "Like",
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.dots),
                contentDescription = "Like",
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(15))
                    .clickable { },
                painter = userImagePainter,
                contentDescription = null
            )
        }


    }
}

@Composable
fun TopReelsNavigation() {
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

@Composable
fun ReelLikesText(firstLike: String, likesNumber: Int) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White, fontSize = 13.sp)) {
                append("Liked by ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White, fontSize = 13.sp)) {
                append("$firstLike ")
            }
            withStyle(style = SpanStyle(color = Color.White, fontSize = 13.sp)) {
                append("and ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White, fontSize = 13.sp)) {
                append("${likesNumber - 1} others ")
            }
        }
    )
}

@Composable
fun ExoPlayerVideoPlayer(
    context: Context,
    videoUrl: String,
    modifier: Modifier = Modifier
) {
    var player by remember {
        mutableStateOf<ExoPlayer?>(null)
    }

    DisposableEffect(
        AndroidView(factory = {
            PlayerView(context).apply {
                player = ExoPlayer.Builder(context).build().also { exoPlayer ->
                    exoPlayer.setMediaItem(MediaItem.fromUri(videoUrl))
                    exoPlayer.prepare()
                    exoPlayer.playWhenReady = true
                    player = exoPlayer
                    this.player = exoPlayer
                }
            }
        }, modifier = modifier)
    ) {
        onDispose {
            player?.release()
        }
    }
}