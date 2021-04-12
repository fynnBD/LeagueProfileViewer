package com.example.leagueprofileviewer.netword

import com.example.leagueprofileviewer.datatypes.summoner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface LeagueInterface {
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    @Headers("X-Riot-Token: RGAPI-dbc57848-c40f-4d3f-8b56-5a56acca409d")
    fun getPlayerInfo(@Path("summonerName")summonerName : String) : Call<summoner>

    @GET("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    @Headers("X-Riot-Token: RGAPI-dbc57848-c40f-4d3f-8b56-5a56acca409d")
    fun getSummonerByID(@Path("encryptedPUUID")PUUID : String) : Call<summoner>
}