package com.example.myapplication.network

import com.example.myapplication.utils.BASE_URL
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object RetrofitHandler {

    private const val cacheSize = (5 * 1024 * 1024 // 5 MB
            ).toLong()

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private val client = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor)
        //.header("Cache-Control", "public, max-stale=" + 60 * 60 * 24)
        .build()




    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getWebService():NewsWebService{
        return retrofit.create(NewsWebService::class.java)
    }

}