package com.example.instagramcomposeclone.ui.theme.screens

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.components.TopProfileNavigation
import com.example.instagramcomposeclone.ui.theme.instagramBlue
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import com.example.instagramcomposeclone.model.User
import com.example.instagramcomposeclone.ui.theme.components.ProfileDetails

@Composable
fun ProfileScreen(user: User) {
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

    var topBarOffset by remember { mutableFloatStateOf(0f) }
    val animatedTopBarOffset by animateFloatAsState(
        targetValue = topBarOffset, label = ""
    )

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffset + delta
                topBarOffset = newOffset.coerceIn(-100f, 0f)
                return Offset.Zero
            }
        }
    }
    val scrollState = rememberLazyListState()

    val configuration = LocalConfiguration.current
    val postTabHeight = calculatePostTabHeight(configuration, imageResourceList.size)

    Box(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(nestedScrollConnection)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 56.dp),
            state = scrollState
        ) {

            item { ProfileDetails(publications = imageResourceList.size) }

            item {
                CustomTabRow(
                    selectedTabIndex = selectedTab,
                    onTabSelected = { selectedTab = it },
                    modifier = Modifier.background(colorScheme.onBackground)
                )
            }
            item {
                AnimatedContent(
                    targetState = selectedTab,
                    transitionSpec = {
                        if (targetState > initialState) {
                            (slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn()).togetherWith(
                                slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
                            )
                        } else {
                            (slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn()).togetherWith(
                                slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut()
                            )
                        }
                    }, label = ""
                ) { targetTab ->
                    when (targetTab) {
                        0 -> Box(modifier = Modifier.height(postTabHeight.dp)) { PostsGrid(imageResourceList) }
                        1 -> Box(modifier = Modifier.height(500.dp)) { ReelsGrid() }
                        2 -> Box(modifier = Modifier.height(500.dp)) { TaggedGrid() }
                    }
                }
            }
        }
    }

    TopProfileNavigation(modifier = Modifier.offset(y = animatedTopBarOffset.dp), username = user.username)
}

fun calculatePostTabHeight(configuration: Configuration, imageResourceListSize: Int): Int{
    val screenWidth = configuration.screenWidthDp
    val postImageWidth = screenWidth/3
    return (imageResourceListSize/3 * postImageWidth)

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
                    .background(colorScheme.onBackground)
            )
        },
        divider = {}
    ) {
        Tab( modifier = Modifier.background(colorScheme.background),
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) },
            icon = { Icon(painter = painterResource(id = R.drawable.grid), contentDescription = null, tint = colorScheme.onBackground) }
        )
        Tab( modifier = Modifier.background(colorScheme.background),
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) },
            icon = { Icon(painter = painterResource(id = R.drawable.play), contentDescription = null, tint = colorScheme.onBackground) }
        )
        Tab( modifier = Modifier.background(colorScheme.background),
            selected = selectedTabIndex == 2,
            onClick = { onTabSelected(2) },
            icon = { Icon(painter = painterResource(id = R.drawable.picture), contentDescription = null, tint = colorScheme.onBackground) }
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
                    .aspectRatio(1f)
                    .clickable { },
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
            color = colorScheme.onBackground,
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
                    .aspectRatio(1f)
                    .clickable { },
                contentScale = ContentScale.Crop)
        }
    }
}
