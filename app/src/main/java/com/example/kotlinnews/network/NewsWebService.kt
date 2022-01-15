package com.example.myapplication.network

import com.example.kotlinnews.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsWebService {
    //https://www.reddit.com/r/kotlin/.json

    @GET("kotlin/.json")
    suspend fun getAllNews():Response<NewsResponse>


}