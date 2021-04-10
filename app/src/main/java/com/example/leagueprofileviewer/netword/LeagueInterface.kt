package com.example.leagueprofileviewer.netword

import com.example.leagueprofileviewer.datatypes.summoner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface LeagueInterface {
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    @Headers("X-Riot-Token: RGAPI-e6073f7d-9470-44a1-9dd2-afdf09423a9e")
    fun getPlayerInfo(@Path("summonerName")summonerName : String) : Call<summoner>

}