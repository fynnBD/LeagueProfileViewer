package com.example.leagueprofileviewer.netword

import android.media.Image
import android.nfc.tech.NfcF.get
import com.example.leagueprofileviewer.UIupdateInterface
import com.example.leagueprofileviewer.datatypes.summoner
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class API(val context : UIupdateInterface) {
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
                    context.summonerCallback(response.body())
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

    fun getSummonerByPuuid(id: String, callBackFunction: (summoner?) -> Unit)
    {
        val request =ServiceBuilder.buildService(LeagueInterface::class.java)
        val call = request.getSummonerByID(id)

        call.enqueue(object : Callback<summoner> {
            override fun onResponse(call: Call<summoner>, response: Response<summoner>) {
                if(response.isSuccessful)
                {
                    println("blah")
                    callBackFunction(response.body())
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