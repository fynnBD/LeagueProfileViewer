package com.example.leagueprofileviewer

import android.content.Context
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

class MatchHistoryAdapter(
    var matches: ArrayList<Match>,
    var champData: HashMap<String, Champ>?,
    context: Context
) :
    RecyclerView.Adapter<MatchHistoryAdapter.ListingHolder>()
{
    val context = context

    class ListingHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        var image = view.findViewById<ImageView>(R.id.image)
        var title = view.findViewById<TextView>(R.id.title)
        var desc = view.findViewById<TextView>(R.id.desc)
        var holder = view.findViewById<CardView>(R.id.carView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.matchcard, parent, false)
        return ListingHolder(v)
    }

    override fun onBindViewHolder(holder: ListingHolder, position: Int) {
        var selectedMatch =matches[position]
        getImageFromChampId(selectedMatch.champion, holder.image)
        //setWinLoseBackGround(holder, selectedMatch.)
    }

    private fun getImageFromChampId(champion: String, image: ImageView){
        var url = "https://ddragon.leagueoflegends.com/cdn/11.7.1/img/champion/${getChampNameFromId(champion)}.png"
        Picasso.get().load(url).into(image)
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
        return matches.size
    }
}
