package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramRed

@Composable
fun TopProfileNavigation(modifier: Modifier = Modifier,
                         username: String = "peter_b_parker",
                         notificationNumber: Int = 9
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .background(colorScheme.background)) {
        TopNavigationBar(username = username, notificationNumber = notificationNumber)
    }
}

@Composable
fun TopNavigationBar(username: String, notificationNumber: Int) {
    Row(
        modifier = Modifier
            .background(colorScheme.background)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .clickable {  },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
        ) {
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = R.drawable.lock),
                contentDescription = "locked profile",
                tint = colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = username,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = colorScheme.onBackground
            )

            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .background(instagramRed, RoundedCornerShape(90))
                    .padding(start = 6.dp, end = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$notificationNumber+", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))


            Icon(
                modifier = Modifier.size(20.dp)
                    .clickable {  },
                painter = painterResource(id = R.drawable.threads),
                contentDescription = "Threads",
                tint = colorScheme.onBackground
            )
        Spacer(modifier = Modifier.width(12.dp))
            Icon(
                modifier = Modifier.size(24.dp)
                    .clickable {  },
                painter = painterResource(id = R.drawable.plus_small_border),
                contentDescription = "New post",
                tint = colorScheme.onBackground
            )
        Spacer(modifier = Modifier.width(12.dp))
            Icon(
                modifier = Modifier.size(24.dp)
                    .clickable {  },
                painter = painterResource(id = R.drawable.menu_burger),
                contentDescription = "Menu",
                tint = colorScheme.onBackground
            )
    }
}


@Preview(showBackground = true)
@Composable
fun TopProfileNavigationPreview() {
    TopProfileNavigation()
}
