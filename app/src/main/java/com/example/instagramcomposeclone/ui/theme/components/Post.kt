package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.model.Post
import com.example.instagramcomposeclone.ui.theme.hashtagDark
import com.example.instagramcomposeclone.ui.theme.hashtagLight

val postPlaceholder: Post = Post(
    id = 1,
    username = "norman_osborn",
    userImage = R.drawable.norman_osborn,
    postImages = mutableListOf(R.drawable.norman_osborn_experiment),
    postDescription = "Everything is prepared for this new experiment. I hope everything goes well.",
    postDate = "1. june, 2002.",
    firstLike = "osborn_jr",
    likesNumber = 535,
    firstImage = R.drawable.harry_osborn,
    secondImage = R.drawable.otto_octavius,
    thirdImage = R.drawable.jonah_jameson,
    location = "Oscorp")
@Preview
@Composable
fun Post(post: Post = postPlaceholder) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp)
        .background(MaterialTheme.colorScheme.background)) {

        PostHeader(post.username, post.userImage, post.location)

        if(post.postImages.size == 1)
        {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = post.postImages[0]),
                contentDescription = null
            )
            PostOptions()
        }
        else{
            val pagerState = rememberPagerState(initialPage = 0, pageCount = { post.postImages.size })
            ImagePager(post.postImages, pagerState)
            PostOptions(post.postImages.size, pagerState = pagerState)
        }

        PostLikes(post.firstLike, post.likesNumber, post.firstImage, post.secondImage, post.thirdImage)

        PostDescriptionText(post.username, post.postDescription)

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
            text = post.postDate,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun PostHeader(username: String, imageResource: Int, location: String?) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        val userImagePainter = rememberAsyncImagePainter(model = imageResource)
        Image(modifier = Modifier
            .size(30.dp)
            .clip(CircleShape),
            painter = userImagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = username,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            if(location!=null)
            {
                Text(
                    text = location,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 10.sp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(modifier = Modifier
            .size(24.dp),
            painter = painterResource(id = R.drawable.dots),
            contentDescription = "Options",
            tint = MaterialTheme.colorScheme.onBackground
        )

    }
}

@Composable
fun PostOptions(imagesNumber: Int = 0, pagerState: PagerState? = null) {

    Box {
        if(imagesNumber!=0 && pagerState!=null){
            PageIndicator(imagesNumber, pagerState)
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Icon(modifier = Modifier
                .size(28.dp)
                .clickable { },
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(modifier = Modifier
                .size(28.dp)
                .clickable { },
                painter = painterResource(id = R.drawable.comment),
                contentDescription = "Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(modifier = Modifier
                .size(28.dp)
                .clickable { },
                painter = painterResource(id = R.drawable.paper_plane),
                contentDescription = "Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(modifier = Modifier
                .size(28.dp)
                .clickable { },
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = "Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }


}

@Composable
fun PostLikes(firstLike: String, likesNumber: Int, firstImage: Int, secondImage: Int, thirdImage: Int) {
    val firstImagePainter = rememberAsyncImagePainter(model = firstImage)
    val secondImagePainter = rememberAsyncImagePainter(model = secondImage)
    val thirdImagePainter = rememberAsyncImagePainter(model = thirdImage)

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Row(
            horizontalArrangement = Arrangement.spacedBy((-6).dp)
        ) {
            Box(modifier = Modifier
                .zIndex(2f)
                .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                .padding(2.dp)) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape),
                    painter = firstImagePainter,
                    contentDescription = null
                )
            }
            Box(modifier = Modifier
                .zIndex(1f)
                .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                .padding(2.dp)) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape),
                    painter = secondImagePainter,
                    contentDescription = null
                )
            }
            Box(modifier = Modifier
                .zIndex(0f)
                .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                .padding(2.dp)) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape),
                    painter = thirdImagePainter,
                    contentDescription = null
                )
            }
        }

        PostLikesText(firstLike, likesNumber)
    }
}

@Composable
fun PostLikesText(firstLike: String, likesNumber: Int) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 13.sp)) {
                append("Liked by ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground, fontSize = 13.sp)) {
                append("$firstLike ")
            }
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 13.sp)) {
                append("and ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground, fontSize = 13.sp)) {
                append("${likesNumber - 1} others ")
            }
        }
    )
}

@Composable
fun PostDescriptionText(username: String, description: String) {
    var hashtagColor = hashtagDark
    if(isSystemInDarkTheme()) hashtagColor = hashtagLight
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground)
            ) {
                append("$username ")
            }
            val words = description.split(" ")
            words.forEach { word ->
                if (word.startsWith("#")) {
                    withStyle(style = SpanStyle(
                        fontSize = 13.sp,
                        color = hashtagColor)
                    ) {
                        append("$word ")
                    }
                } else {
                    withStyle(style = SpanStyle(
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onBackground)
                    ) {
                        append("$word ")
                    }
                }
            }
        },
        lineHeight = 15.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp, start = 10.dp, end = 10.dp)
    )
}

