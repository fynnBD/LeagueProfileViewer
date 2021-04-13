package com.example.leagueprofileviewer.datatypes

data class ChampInfo(val data: HashMap<String, Champ>)

data class Champ(val id : String, val key : String,
val title: String,
val blurb: String)
