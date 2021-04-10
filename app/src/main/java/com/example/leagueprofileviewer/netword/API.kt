package com.example.leagueprofileviewer.netword

import android.content.Context
import com.example.leagueprofileviewer.MainActivity
import com.example.leagueprofileviewer.datatypes.summoner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class API(val context : Context) {
    var isComplete : Boolean = false;
    var result : Any? = null

    fun getSummonerByName(name : String)
    {
        isComplete = false
        val request =ServiceBuilder.buildService(LeagueInterface::class.java)
        val call = request.getPlayerInfo(name)

        call.enqueue(object : Callback<summoner> {
            override fun onResponse(call: Call<summoner>, response: Response<summoner>) {
                if(response.isSuccessful)
                {
                    println("blah")
                    (context as MainActivity).summonerCallback(response.body())
                }
                else
                {
                    println("fail")
                    println(response.message())
                }
            }

            override fun onFailure(call: Call<summoner>, t: Throwable) {
                println("hard fail")
            }
        })
    }
}