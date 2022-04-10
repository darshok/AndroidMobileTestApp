package com.example.androidmobiletestapp.api

import com.example.androidmobiletestapp.data.PlanetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPlanetsByCount(@Url url: String): Response<List<PlanetResponse>>
}