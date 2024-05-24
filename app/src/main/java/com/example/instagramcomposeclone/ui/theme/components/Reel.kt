package com.example.instagramcomposeclone.ui.theme.components

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.media3.common.Player.REPEAT_MODE_ONE
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.rememberAsyncImagePainter
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.model.Reel

val reelPreview = Reel(
id = 1,
username = "mj_watson",
userImage = R.drawable.mary_jane,
description = "Sunset",
firstLike = "norman_osborn",
likesNumber = 303,
videoUrl = "https://www.shutterstock.com/shutterstock/videos/3464864831/preview/stock-footage-sunset-view-at-the-beach-in-koh-kood-thailand.webm"
)
@Preview
@Composable
fun Reel(
    modifier: Modifier = Modifier,
    reel: Reel = reelPreview,
    context: Context = LocalContext.current
    ) {

    Box(modifier = modifier) {


        ExoPlayerVideoPlayer(
            context = context,
            videoUrl = reel.videoUrl,
            modifier = Modifier.fillMaxSize()
        )


        Column(modifier = Modifier.fillMaxSize()){
            Spacer(modifier = Modifier.weight(1f))
            BottomReelNavigation(
                userImage = reel.userImage,
                username = reel.username,
                description = reel.description,
                firstLike = reel.firstLike,
                likesNumber = reel.likesNumber
            )
        }

    }
}

@Composable
fun BottomReelNavigation(userImage: Int, username: String, description: String, firstLike: String, likesNumber: Int) {
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
                    exoPlayer.repeatMode = REPEAT_MODE_ONE
                    exoPlayer.volume = 0f
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