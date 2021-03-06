package com.example.leagueprofileviewer.netword


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder{
    private val client = OkHttpClient.Builder().build()

    val retrofit = Retrofit.Builder()
            .baseUrl("https://oc1.api.riotgames.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun<T> buildService(service : Class<T>): T{
        return retrofit.create(service)
    }
}