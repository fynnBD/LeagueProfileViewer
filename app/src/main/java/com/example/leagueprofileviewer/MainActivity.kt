package com.example.leagueprofileviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.leagueprofileviewer.datatypes.summoner
import com.example.leagueprofileviewer.netword.API

class MainActivity : AppCompatActivity(), UIupdateInterface {
    val API : API = API(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view : View)
    {
        getSummoner(findViewById<EditText>(R.id.nameBox).text.toString())
    }

    private fun getSummoner(name : String) {
        API.getSummonerByName(name)
    }

    override fun summonerCallback(summoner: summoner?) {
        var intent = Intent(this, SummonerProfile::class.java)
        if (summoner != null) {
            intent.putExtra("piid", summoner.puuid)
            startActivity(intent)
        }
    }

}