package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramBlue
import com.example.instagramcomposeclone.ui.theme.instagramDarkGray
import com.example.instagramcomposeclone.ui.theme.instagramRed

@Composable
fun TopProfileNavigation(username: String = "peter_b_parker",
                         imageResource: Int = R.drawable.profile_photo,
                         name: String = "Peter Parker",
                         description: String = "Photographer | Daily Bugle",
                         publications: Int = 153,
                         followers: Int = 209,
                         following: Int = 109,
                         notificationNumber: Int = 9,
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(colorScheme.background)) {
        TopNavigationBar(username = username, notificationNumber = notificationNumber)
        ProfileHeader(imageResource = imageResource, publications = publications, followers = followers, following = following)
        ProfileInfo(name = name, description = description)
        ProfileActions()
        HighlightedStories()
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

@Composable
fun ProfileHeader(imageResource: Int, publications: Int, followers: Int, following: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.clickable {  }) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = painterResource(id = imageResource),
                contentDescription = "profile photo"
            )
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .background(instagramBlue, shape = CircleShape)
                    .align(Alignment.BottomEnd),
                painter = painterResource(id = R.drawable.plus_small),
                contentDescription = "New story",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = publications.toString(),
                    color = colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Publications", color = colorScheme.onBackground, fontSize = 12.sp)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = followers.toString(),
                    color = colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Followers", color = colorScheme.onBackground, fontSize = 12.sp)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = following.toString(),
                    color = colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Following", color = colorScheme.onBackground, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ProfileInfo(name: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        Text(text = name, color = colorScheme.onBackground, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
        Text(text = description, color = colorScheme.onBackground, fontSize = 13.sp)
    }
}

@Composable
fun ProfileActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Modify profile", fontSize = 13.sp, color = colorScheme.onBackground)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Share profile", fontSize = 13.sp, color = colorScheme.onBackground)
        }

        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier.size(32.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
            shape = RoundedCornerShape(20),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                modifier = Modifier.size(14.dp),
                painter = painterResource(id = R.drawable.user_add),
                contentDescription = "Add user",
                tint = colorScheme.onBackground
            )
        }
    }
}

@Composable
fun HighlightedStories() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(colorScheme.background)
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        ) {

        Column(modifier = Modifier
            .padding(end = 10.dp)
            .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier
                .size(64.dp)
                .border(2.dp, instagramDarkGray, CircleShape)
                .padding(4.dp)
                .clip(CircleShape),
                painter = painterResource(id = R.drawable.bugle_photo),
                contentDescription = "Photography highlights"
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Photography", color = colorScheme.onBackground, fontSize = 11.sp)
        }

        Column(modifier = Modifier
            .padding(end = 10.dp)
            .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier
                .size(64.dp)
                .border(2.dp, instagramDarkGray, CircleShape)
                .padding(4.dp)
                .clip(CircleShape),
                painter = painterResource(id = R.drawable.family_photo),
                contentDescription = "Bugle highlights"
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Family", color = colorScheme.onBackground, fontSize = 11.sp)
        }

        Column(modifier = Modifier.clickable {  },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(modifier = Modifier
                .size(64.dp)
                .border(1.dp, colorScheme.onBackground, CircleShape)
                .padding(20.dp),
                tint = colorScheme.onBackground,
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "New highlight",

            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "New", color = colorScheme.onBackground, fontSize = 11.sp)
        }

        }


}

@Preview(showBackground = true)
@Composable
fun TopProfileNavigationPreview() {
    TopProfileNavigation()
}
