package com.example.instagramcomposeclone.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val instagramRed = Color(0xFFFD0635)
val instagramDarkGray = Color(0xFF262626)
val instagramLightGray = Color(0xFFEFEFEF)
val instagramBlue = Color(0xFF0094F5)
val hashtagLight = Color(0xFFBAEBFF)
val hashtagDark = Color(0xFF395375)
val instagramGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF962FBF),
        Color(0xFFD62976),
        Color(0xFFFA7E1E),
        Color(0xFFFEDA75)
    ),
    start = Offset(250f, 50f),
    end = Offset(100f, 300f)
    )

