package com.example.leagueprofileviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.leagueprofileviewer.datatypes.summoner
import com.example.leagueprofileviewer.netword.API
import com.squareup.picasso.Picasso

class SummonerProfile : AppCompatActivity(), UIupdateInterface {
    val api : API = API(this)
    var Summoner : summoner? = null

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
        }
    }

    fun updateIcon(profileIconId: String)
    {
        println("YUNG BLUD")
        println(profileIconId)
        val iconView = findViewById<ImageView>(R.id.imageView)
        val URL = "https://ddragon.leagueoflegends.com/cdn/11.7.1/img/profileicon/${profileIconId}.png"
        println(URL)
        Picasso.get().isLoggingEnabled = true
        val icon = Picasso.get().load(URL).into(iconView)
    }
}