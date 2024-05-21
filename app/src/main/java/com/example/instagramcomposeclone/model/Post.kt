package com.example.instagramcomposeclone.model

data class Post(val id:Int, val username: String, val userImage: Int, val postImages: List<Int>, val postDescription: String, val postDate: String, val firstLike: String, val likesNumber: Int, val firstImage: Int, val secondImage: Int, val thirdImage: Int) {
}