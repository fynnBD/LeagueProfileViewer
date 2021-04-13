package com.example.leagueprofileviewer.netword

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DDServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ddragon.leagueoflegends.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service : Class<T>): T{
        return retrofit.create(service)
    }
}