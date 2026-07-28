package com.abhinav.fable.data

import androidx.annotation.DrawableRes

data class Story(
    val id: Int,
    val title: String,
    val author: String,
    val readTime: String,
    val category: String,
    val description: String,
    val content: List<String>,
    @DrawableRes val coverImages: Int,
    val isFavorite: Boolean = false,
)