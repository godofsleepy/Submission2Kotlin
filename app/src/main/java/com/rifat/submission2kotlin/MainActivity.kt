package com.rifat.submission2kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifat.submission2kotlin.adapter.LeagueAdapter
import com.rifat.submission2kotlin.model.League
import com.rifat.submission2kotlin.search.SearchActivity
import com.rifat.submission2kotlin.ui.detailLeague.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data:MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        recview_league.layoutManager = LinearLayoutManager(this)
        recview_league.adapter = LeagueAdapter(data){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data", it)
            startActivity(intent)
        }
    }

    private fun initData(){
        val image = resources.obtainTypedArray(R.array.league_image)
        val name = resources.getStringArray(R.array.league_name)
        val id = resources.getStringArray(R.array.id_league)

        data.clear()
        for (i in name.indices){
            data.add(League(id[i],name[i],image.getResourceId(i,0)))
        }
        image.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search){
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        return true
    }
}
