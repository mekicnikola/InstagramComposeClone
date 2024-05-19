package com.example.instagramcomposeclone.model

data class User(val profileImageResource: Int, val username: String, val name: String, val description: String,
                val publications: Int, val followers: Int, val following: Int, val notificationNumber: Int )