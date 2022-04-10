package com.example.androidmobiletestapp.data

import com.google.gson.annotations.SerializedName

data class PlanetResponse(
    @SerializedName("date") var date: String,
    @SerializedName("copyright") var copyright: String,
    @SerializedName("title") var title: String,
    @SerializedName("url") var imageUrl: String
)