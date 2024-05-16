package com.example.instagramcomposeclone.ui.theme.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.components.TopProfileNavigation
import com.example.instagramcomposeclone.ui.theme.instagramBlue

@Composable
fun ProfileScreen(username:String, modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val imageResourceList = listOf(
    R.drawable.nature_image,
    R.drawable.spiderman_air,
    R.drawable.bugle_photo,
    R.drawable.photographing,
    R.drawable.spiderman_drawing,
    R.drawable.spiderman_crawling,
    R.drawable.family_photo,
    R.drawable.house,
    R.drawable.spiderman_bridge
    )
    Scaffold(
        topBar = { TopProfileNavigation(username = username) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Black)
        ) {
            CustomTabRow(
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it },
                modifier = Modifier.background(Color.Black)
            )
            AnimatedContent(targetState = selectedTab,
                transitionSpec =  {
                    if(targetState > initialState) {
                        (slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn()).togetherWith(
                            slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
                        )
                    }
                    else {
                        (slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn()).togetherWith(
                            slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut()
                        )
                    }

                }, label = ""
            ) { targetTab ->
                when (targetTab) {
                    0 -> PostsGrid(imageResourceList)
                    1 -> ReelsGrid()
                    2 -> TaggedGrid()
                }
            }


        }
    }
}

@Composable
fun CustomTabRow(selectedTabIndex: Int, onTabSelected: (Int) -> Unit, modifier: Modifier = Modifier) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        indicator = { tabPositions ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(2.dp)
                    .background(Color.White)
            )
        },
        divider = {}
    ) {
        Tab( modifier = Modifier.background(Color.Black),
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) },
            icon = { Icon(painter = painterResource(id = R.drawable.grid), contentDescription = null, tint = Color.White) }
        )
        Tab( modifier = Modifier.background(Color.Black),
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) },
            icon = { Icon(painter = painterResource(id = R.drawable.play), contentDescription = null, tint = Color.White) }
        )
        Tab( modifier = Modifier.background(Color.Black),
            selected = selectedTabIndex == 2,
            onClick = { onTabSelected(2) },
            icon = { Icon(painter = painterResource(id = R.drawable.picture), contentDescription = null, tint = Color.White) }
        )
    }
}

@Composable
fun PostsGrid(imageResourceList: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {

        items(imageResourceList.size) { index ->
            Image(
                painter = painterResource(id = imageResourceList[index]),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)
        }
    }
}
@Preview
@Composable
fun ReelsGrid() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Share the moment with the world",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Make your first Reels video",
            color = instagramBlue,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun TaggedGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        items(1) { index ->
            Image(
                painter = painterResource(id = when (index) {
                    0-> R.drawable.friends
                    else -> R.drawable.friends
                }),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)
        }
    }
}
