package com.rifat.submission2kotlin.ui.detailLeague

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.adapter.TabAdapter
import com.rifat.submission2kotlin.model.League
import com.rifat.submission2kotlin.model.LeagueDetail
import com.rifat.submission2kotlin.ui.lastMatch.LastFragment
import com.rifat.submission2kotlin.ui.nextMatch.NextFragment
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.AnkoLogger

class DetailActivity : AppCompatActivity(),DetailView, AnkoLogger {
    private lateinit var presenter: DetailPresenter
    private lateinit var leagueData: League

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        leagueData = intent.getParcelableExtra("data")!!
        presenter = DetailPresenter(this)
        presenter.getLeagueDetail(leagueData)
    }

    override fun showLoading() {
        progress_detail.show()
        text_leagueCountry.visibility = View.INVISIBLE
        text_leagueDesc.visibility = View.INVISIBLE
        text_leagueName.visibility = View.INVISIBLE
        text_leagueWebsite.visibility = View.INVISIBLE
        cardView.visibility = View.INVISIBLE
        tabLayout.visibility = View.INVISIBLE
        image_LeagueDetail.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        progress_detail.hide()
        cardView.visibility = View.VISIBLE
        text_leagueCountry.visibility = View.VISIBLE
        text_leagueDesc.visibility = View.VISIBLE
        text_leagueName.visibility = View.VISIBLE
        text_leagueWebsite.visibility = View.VISIBLE
        tabLayout.visibility = View.VISIBLE
        image_LeagueDetail.visibility = View.VISIBLE
    }

    override fun showTeamList(data: LeagueDetail) {
        Glide.with(this).load(leagueData.imageLeague).into(image_LeagueDetail)
        text_leagueName.text = data.name
        text_leagueCountry.text = data.country
        text_leagueWebsite.text = data.website
        text_leagueDesc.text = data.description

        tabLayout.setupWithViewPager(viewPager, true)
        setViewPager(viewPager, data)
    }

    private fun setViewPager(viewPager: ViewPager, leagueDetail: LeagueDetail){
        val tabAdapter = TabAdapter(supportFragmentManager)
        tabAdapter.addFragment(LastFragment(leagueDetail), "Last Match")
        tabAdapter.addFragment(NextFragment(leagueDetail), "Next Match")
        viewPager.adapter = tabAdapter
    }


}
