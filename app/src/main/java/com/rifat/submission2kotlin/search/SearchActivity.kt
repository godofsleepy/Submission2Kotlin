package com.rifat.submission2kotlin.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.adapter.MatchAdapter
import com.rifat.submission2kotlin.model.Match
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), viewSearch {
    private lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter = SearchPresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.searching(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        searchView.isIconified = false
        searchView.setIconifiedByDefault(false)
        return true
    }

    override fun showLoading() {
        progress_search.show()
    }

    override fun hideLoading() {
        progress_search.hide()
    }

    override fun showMatchList(data: List<Match>?) {
        if (data != null){
            recview_search.layoutManager = LinearLayoutManager(this)
            recview_search.adapter = MatchAdapter(data, this)
        }
    }


}

