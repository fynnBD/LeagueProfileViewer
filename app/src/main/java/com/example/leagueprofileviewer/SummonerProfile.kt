package com.example.leagueprofileviewer

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueprofileviewer.datatypes.Champ
import com.example.leagueprofileviewer.datatypes.Match
import com.example.leagueprofileviewer.datatypes.MatchInfo
import com.example.leagueprofileviewer.datatypes.summoner
import com.example.leagueprofileviewer.netword.API
import com.squareup.picasso.Picasso


class SummonerProfile : AppCompatActivity(), UIupdateInterface {
    val api: API = API(this)
    var Summoner: summoner? = null
    var champData: HashMap<String, Champ>? = null
    var matches: List<Match>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summoner_profile)
        getSummoner(intent.getStringExtra("piid").toString())
        println("hehehehehe")
    }

    fun getSummoner(id: String) {
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

    fun setChampInfo(champinfo: HashMap<String, Champ>) {
        champData = champinfo
        api.getMatchHistoryById(Summoner!!.accountId, this::updateMatchHistory1)
    }

    fun updateMatchHistory1(matches: List<Match>) {

        var subMatches = matches.subList(0, 10)
        this.matches = subMatches

        for(i in subMatches)
        {
            api.getMatchDetails(i.gameId, matches.indexOf(i), subMatches.size, this::updateMatchHistory2)
        }
    }

    fun updateMatchHistory2(info: MatchInfo, index: Int, maxIndex: Int)
    {
        matches?.get(index)?.matchDetails = info
        println(isMatchesLoaded())
        if(isMatchesLoaded())
        {
            var recycler = findViewById<RecyclerView>(R.id.matchHistoryRecycler)
            recycler.adapter = MatchHistoryAdapter(matches, champData, Summoner!!.accountId)
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.viewTreeObserver.addOnGlobalLayoutListener(OnGlobalLayoutListener {
                removeMatchLoading()
            })
        }
    }

    fun removeMatchLoading()
    {
        var thing = findViewById<FrameLayout>(R.id.matchLayout)
    }

    private fun updateName(name: String) {
        findViewById<TextView>(R.id.summonerName).text = name
    }

    private fun updateLevel(level: String)
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

    fun isMatchesLoaded() : Boolean
    {
        var matchesSearch = matches
        if(matchesSearch != null){
            for(i in matchesSearch){
                if(i.matchDetails == null){return false}
            }
            return true
        }
        return false
    }
}
