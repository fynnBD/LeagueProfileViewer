package com.example.leagueprofileviewer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.leagueprofileviewer.datatypes.Champ
import com.example.leagueprofileviewer.datatypes.Match
import com.squareup.picasso.Picasso

/**
 * Adapter for the match history list
 *
 * Uses match history information, combined with champion data to build
 * a list of the last 40 or so matches associated with the provided account
 *
 * @param matches list of the last 40 or so matches, built from JSON object
 * @param champData preloaded champ info set, contains names, Ids, abilities and image URLS
 */
class MatchHistoryAdapter(
        var matches: List<Match>?,
        var champData: HashMap<String, Champ>?,
        var accountId: String
) :
    RecyclerView.Adapter<MatchHistoryAdapter.ListingHolder>()
{


    /**
     * Template holder class to hold references to each part of the match-cardview
     */
    class ListingHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        var image = view.findViewById<ImageView>(R.id.image)
        var title = view.findViewById<TextView>(R.id.title)
        var desc = view.findViewById<TextView>(R.id.desc)
        var holder = view.findViewById<CardView>(R.id.carView)
        var p0 = view.findViewById<TextView>(R.id.player0)
        var p1 = view.findViewById<TextView>(R.id.player1)
        var p2 = view.findViewById<TextView>(R.id.player2)
        var p3 = view.findViewById<TextView>(R.id.player3)
        var p4 = view.findViewById<TextView>(R.id.player4)
        var playerList = arrayOf(p0, p1, p2, p3, p4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.matchcard, parent, false)
        return ListingHolder(v)
    }

    override fun onBindViewHolder(holder: ListingHolder, position: Int) {
        println("EAT MY ASS WHORE")
        var selectedMatch = matches?.get(position)
        if (selectedMatch != null) {
            getImageFromChampId(selectedMatch.champion, holder.image)
            setPlayers(holder, selectedMatch)
            holder.title.text = selectedMatch.lane
            holder.desc.text = selectedMatch.role
        }

    }

    private fun getImageFromChampId(champion: String, image: ImageView){
        var url = "https://ddragon.leagueoflegends.com/cdn/11.7.1/img/champion/${getChampNameFromId(champion)}.png"
        Picasso.get().load(url).into(image)
    }

    private fun setBackgroundColor(base : CardView, selectedMatch : Match)
    {
        base.setBackgroundColor(Color.BLUE)
    }

    private fun setPlayers(holder : ListingHolder, selectedMatch: Match)
    {
        var index = 0
        for(i in selectedMatch.matchDetails.participantIdentities.subList(0,5))
        {
            holder.playerList[index].text = i.player.summonerName
            index++
        }
    }

    fun getChampNameFromId(id : String) : String
    {
        for(i in champData!!.keys)
        {
            println(id + " " + champData!!.get(i)!!.key)
            if (champData!!.get(i)!!.key == id)
            {
                return i
            }
        }
        return "Ahri"
    }

    override fun getItemCount(): Int {
        return matches!!.size
    }
}
