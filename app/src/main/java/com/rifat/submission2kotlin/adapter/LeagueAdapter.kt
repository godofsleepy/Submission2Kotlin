package com.rifat.submission2kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.model.League
import kotlinx.android.synthetic.main.list_league.view.*


class LeagueAdapter(private val League:List<League>, private val listener: (League)->Unit) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view) {
        fun bindItem(items:League, listener: (League) -> Unit){
            Glide.with(itemView.context)
                .load(items.imageLeague)
                .into(itemView.image_league)

            itemView.text_league.text = items.leagueName

            itemView.setOnClickListener{
                listener(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_league,parent,false))
    }

    override fun getItemCount(): Int = League.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(League[position], listener)
    }
}