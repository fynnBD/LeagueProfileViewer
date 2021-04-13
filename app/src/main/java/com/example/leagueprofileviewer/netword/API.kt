package com.example.leagueprofileviewer.netword

import com.example.leagueprofileviewer.UIupdateInterface
import com.example.leagueprofileviewer.datatypes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.KFunction1

class API(val context : UIupdateInterface) {
    var isComplete : Boolean = false
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
                    println("fail on get summoner")
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
                    println("fail on get by PUUID")
                    println(response.message())
                }
            }

            override fun onFailure(call: Call<summoner>, t: Throwable) {
                println("hard fail")
            }
        })
    }

    fun getMatchHistoryById(id: String, callBackFunction: (List<Match>) -> Unit)
    {
        val request =ServiceBuilder.buildService(LeagueInterface::class.java)
        val call = request.getMatchIdsByID(id)

        call.enqueue(object : Callback<MatchHistory>{
            override fun onResponse(call: Call<MatchHistory>, response: Response<MatchHistory>) {
                if (response.isSuccessful) {
                    println("yay")
                    callBackFunction(response.body()!!.matches)
                }
                else
                {
                    println("Fail on get match History")
                }
            }

            override fun onFailure(call: Call<MatchHistory>, t: Throwable) {
                println("AH FUCK")
            }

        })
    }

    fun getChampInfo(callBackFunction: KFunction1<HashMap<String, Champ>, Unit>) {
        val request =DDServiceBuilder.buildService(LeagueInterface::class.java)
        val call = request.DDChampion()
        println(call.request().url().toString())

        call.enqueue(object : Callback<ChampInfo>
        {
            override fun onResponse(call: Call<ChampInfo>, response: Response<ChampInfo>) {
                if(response.isSuccessful)
                {
                    callBackFunction(response.body()?.data!!)
                }
                else
                {
                    println("fail")
                    println(response.message())
                }
            }

            override fun onFailure(call: Call<ChampInfo>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    fun getMatchDetails(gameId: String, index: Int, maxIndex : Int, callBackFunction: (MatchInfo, Int, Int) -> Unit) {
        val request = ServiceBuilder.buildService(LeagueInterface::class.java)
        val call = request.getMatchDetails(gameId)

        call.enqueue(object : Callback<MatchInfo>
        {
            override fun onResponse(call: Call<MatchInfo>, response: Response<MatchInfo>) {
                if(response.isSuccessful)
                {
                    callBackFunction(response.body()!!, index, maxIndex)
                }
                else
                {
                    println(response.message())
                }
            }

            override fun onFailure(call: Call<MatchInfo>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }


}