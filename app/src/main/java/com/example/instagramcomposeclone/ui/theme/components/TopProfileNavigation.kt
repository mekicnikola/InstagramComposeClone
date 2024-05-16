package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.instagramcomposeclone.ui.theme.instagramGray
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
        .background(Color.Black)) {
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
            .background(Color.Black)
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
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = username,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
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

        Button(
            modifier = Modifier.size(24.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.threads),
                contentDescription = "Threads",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Button(
            modifier = Modifier.size(24.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.plus_small_border),
                contentDescription = "New post",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Button(
            modifier = Modifier.size(24.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.menu_burger),
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProfileHeader(imageResource: Int, publications: Int, followers: Int, following: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.clickable {  }) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
//                painter = painterResource(id = R.drawable.profile_photo),
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
                Text(text = publications.toString(), color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = "Publications", color = Color.White)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = followers.toString(), color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = "Followers", color = Color.White)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = following.toString(), color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = "Followings", color = Color.White)
            }
        }
    }
}

@Composable
fun ProfileInfo(name: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        Text(text = name, color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = description, color = Color.White)
    }
}

@Composable
fun ProfileActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = instagramGray),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Modify profile", fontSize = 13.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = instagramGray),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Share profile", fontSize = 13.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier.size(32.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = instagramGray),
            shape = RoundedCornerShape(20),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                modifier = Modifier.size(14.dp),
                painter = painterResource(id = R.drawable.user_add),
                contentDescription = "Add user",
                tint = Color.White
            )
        }
    }
}

@Composable
fun HighlightedStories() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        ) {

        Column(modifier = Modifier
            .padding(end = 10.dp)
            .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier
                .size(64.dp)
                .border(1.dp, instagramGray, CircleShape)
                .padding(4.dp)
                .clip(CircleShape),
                painter = painterResource(id = R.drawable.bugle_photo),
                contentDescription = "Photography highlights"
            )
            Text(text = "Photography", color = Color.White, fontSize = 11.sp)
        }

        Column(modifier = Modifier
            .padding(end = 10.dp)
            .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier
                .size(64.dp)
                .border(1.dp, instagramGray, CircleShape)
                .padding(4.dp)
                .clip(CircleShape),
                painter = painterResource(id = R.drawable.family_photo),
                contentDescription = "Bugle highlights"
            )
            Text(text = "Family", color = Color.White, fontSize = 11.sp)
        }

        Column(modifier = Modifier.clickable {  },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(modifier = Modifier
                .size(64.dp)
                .border(1.dp, Color.White, CircleShape)
                .padding(20.dp),
                tint = Color.White,
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "New highlight",

            )
            Text(text = "New", color = Color.White, fontSize = 11.sp)
        }

        }


}

@Preview(showBackground = true)
@Composable
fun TopProfileNavigationPreview() {
    TopProfileNavigation()
}