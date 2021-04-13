package com.example.leagueprofileviewer.netword

import com.example.leagueprofileviewer.datatypes.ChampInfo
import com.example.leagueprofileviewer.datatypes.MatchHistory
import com.example.leagueprofileviewer.datatypes.summoner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface LeagueInterface {

    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    @Headers("X-Riot-Token: RGAPI-f1ea1849-9856-4e6f-a3c5-9a1432ac1287")
    fun getPlayerInfo(@Path("summonerName")summonerName : String) : Call<summoner>

    @GET("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    @Headers("X-Riot-Token: RGAPI-f1ea1849-9856-4e6f-a3c5-9a1432ac1287")
    fun getSummonerByID(@Path("encryptedPUUID")PUUID : String) : Call<summoner>

    @GET("/lol/match/v4/matchlists/by-account/{encryptedAccountId}")
    @Headers("X-Riot-Token: RGAPI-f1ea1849-9856-4e6f-a3c5-9a1432ac1287")
    fun getMatchIdsByID(@Path("encryptedAccountId")encryptedAccountId : String) : Call<MatchHistory>

    @GET("/cdn/11.7.1/data/en_US/champion.json")
    fun DDChampion() : Call<ChampInfo>
}