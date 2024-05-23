package com.example.instagramcomposeclone.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramcomposeclone.R
import com.example.instagramcomposeclone.ui.theme.instagramBlue
import com.example.instagramcomposeclone.ui.theme.instagramDarkGray

@Composable
fun ProfileDetails(imageResource: Int = R.drawable.profile_photo,
                   name: String = "Peter Parker",
                   description: String = "Photographer | Daily Bugle",
                   publications: Int = 0,
                   followers: Int = 209,
                   following: Int = 109) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)) {
        ProfileHeader(imageResource = imageResource, publications = publications, followers = followers, following = following)
        ProfileInfo(name = name, description = description)
        ProfileActions()
        HighlightedStories()
    }
}

@Composable
fun ProfileHeader(imageResource: Int, publications: Int, followers: Int, following: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
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
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Publications", color = MaterialTheme.colorScheme.onBackground, fontSize = 12.sp)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = followers.toString(),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Followers", color = MaterialTheme.colorScheme.onBackground, fontSize = 12.sp)
            }

            Column(modifier = Modifier.clickable {  },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = following.toString(),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(text = "Following", color = MaterialTheme.colorScheme.onBackground, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ProfileInfo(name: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        Text(text = name, color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
        Text(text = description, color = MaterialTheme.colorScheme.onBackground, fontSize = 13.sp)
    }
}

@Composable
fun ProfileActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Modify profile", fontSize = 13.sp, color = MaterialTheme.colorScheme.onBackground)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(10)
        ) {
            Text(text = "Share profile", fontSize = 13.sp, color = MaterialTheme.colorScheme.onBackground)
        }

        Spacer(modifier = Modifier.width(5.dp))
        Button(
            modifier = Modifier.size(32.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(20),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                modifier = Modifier.size(14.dp),
                painter = painterResource(id = R.drawable.user_add),
                contentDescription = "Add user",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun HighlightedStories() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
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
            Text(text = "Photography", color = MaterialTheme.colorScheme.onBackground, fontSize = 11.sp)
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
            Text(text = "Family", color = MaterialTheme.colorScheme.onBackground, fontSize = 11.sp)
        }

        Column(modifier = Modifier.clickable {  },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(modifier = Modifier
                .size(64.dp)
                .border(1.dp, MaterialTheme.colorScheme.onBackground, CircleShape)
                .padding(20.dp),
                tint = MaterialTheme.colorScheme.onBackground,
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "New highlight",

                )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "New", color = MaterialTheme.colorScheme.onBackground, fontSize = 11.sp)
        }

    }


}