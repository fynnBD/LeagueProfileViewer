package com.example.leagueprofileviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout

class SummonerProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summoner_profile)

        //Thread.sleep(3000)
        //findViewById<ConstraintLayout>(R.id.loadingFrame).visibility = View.INVISIBLE
    }
}