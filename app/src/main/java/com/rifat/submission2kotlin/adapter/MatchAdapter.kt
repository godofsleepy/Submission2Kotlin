package com.rifat.submission2kotlin.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import com.rifat.submission2kotlin.model.Match
import com.rifat.submission2kotlin.model.RawTeamResponse
import com.rifat.submission2kotlin.model.TeamResponse
import com.rifat.submission2kotlin.ui.detailMatch.DetailMatchActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_match.view.*

class MatchAdapter(private val match:List<Match>, private val context: Context?): RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(items:Match, context: Context?){
            var imgHome: String
            var imgAway: String
            val bundle = Bundle()

            val retrofitInterface: RetrofitInterface = RetrofitClient().getClient().create(
                RetrofitInterface::class.java)

            val home = retrofitInterface.getTeam(items.idHomeTeam)
            val away = retrofitInterface.getTeam(items.idAwayTeam)

            Observable
                .zip(home,away, BiFunction<TeamResponse, TeamResponse, RawTeamResponse>{matchHome, matchAway -> return@BiFunction RawTeamResponse(matchHome,matchAway)})
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    imgHome = it.teamHome.teamResult!![0].teamImage.toString()
                    imgAway = it.teamAway.teamResult!![0].teamImage.toString()

                    Glide.with(context!!).load(imgHome).into(itemView.image_home_match)
                    Glide.with(context).load(imgAway).into(itemView.image_away_match)

                    itemView.text_home.text = items.homeTeam
                    itemView.text_away.text = items.awayTeam
                    itemView.text_dateMatch.text = items.matchDate
                    itemView.text_timeMatch.text = items.matchTime
                    if (items.homeScore != null){
                        itemView.text_scoreaway.text = items.awayScore
                        itemView.text_scorehome.text = items.homeScore
                    }

                    bundle.putString("imgHome", imgHome)
                    bundle.putString("imgAway", imgAway)
                    bundle.putString("id", items.idMatch)
                },{Log.d("Adapter", it.message!!)})

            itemView.setOnClickListener {
                val intent = Intent(context, DetailMatchActivity::class.java)
                intent.putExtra("EXTRA_DATA", bundle)
                context!!.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_match, parent,false))
    }

    override fun getItemCount(): Int = match.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Adapter", "Sport : " +  match[position].sport)
        if (match[position].sport == "Soccer"){
            holder.bindItem(match[position], context)
        }
    }


}
