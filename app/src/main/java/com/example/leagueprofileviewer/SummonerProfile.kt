package com.example.leagueprofileviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueprofileviewer.datatypes.Champ
import com.example.leagueprofileviewer.datatypes.Match
import com.example.leagueprofileviewer.datatypes.summoner
import com.example.leagueprofileviewer.netword.API
import com.squareup.picasso.Picasso

class SummonerProfile : AppCompatActivity(), UIupdateInterface {
    val api : API = API(this)
    var Summoner : summoner? = null
    var champData : HashMap<String, Champ>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summoner_profile)
        getSummoner(intent.getStringExtra("piid").toString())
        println("hehehehehe")
    }

    fun getSummoner(id : String)
    {
        api.getSummonerByPuuid(id, this::summonerCallback)
    }

    override fun summonerCallback(summoner: summoner?) {
        Summoner = summoner
        if (summoner != null) {
            updateIcon(summoner.profileIconId)
            updateName(summoner.name)
            updateLevel(summoner.summonerLevel)
            api.getChampInfo(this::setChampInfo)
        }
    }

    fun setChampInfo(champinfo : HashMap<String, Champ>) {
        champData = champinfo
        api.getMatchHistoryById(Summoner!!.accountId, this::updateMatchHistory)
    }

    fun updateMatchHistory(matches: ArrayList<Match>)
    {
        val recycler = findViewById<RecyclerView>(R.id.matchHistoryRecycler)
        recycler.adapter = MatchHistoryAdapter(matches, champData, this)
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun updateName(name: String) {
        findViewById<TextView>(R.id.summonerName).text = name
    }

    private fun updateLevel(level : String)
    {
        findViewById<TextView>(R.id.levelText).text = level
    }

    fun updateIcon(profileIconId: String)
    {
        val iconView = findViewById<ImageView>(R.id.imageView)
        val URL = "https://ddragon.leagueoflegends.com/cdn/11.7.1/img/profileicon/${profileIconId}.png"
        println(URL)
        val icon = Picasso.get().load(URL).into(iconView)
    }
}