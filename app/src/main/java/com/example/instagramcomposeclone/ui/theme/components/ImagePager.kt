package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramBlue

@Composable
fun ImagePager(images: List<Int> = mutableListOf(R.drawable.jonah_jameson_papers, R.drawable.otto_octavius_experiment), pagerState: PagerState) {

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
fun PageIndicator(imagesNumber: Int, pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(imagesNumber) { index ->
            val color = if (pagerState.currentPage == index) {
                instagramBlue
            } else {
                MaterialTheme.colorScheme.secondary
            }
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(color = color, shape = MaterialTheme.shapes.small)
                    .padding(horizontal = 2.dp)
            )
            if (index < imagesNumber - 1) {
                Spacer(modifier = Modifier.width(2.dp))
            }
        }
    }
}
