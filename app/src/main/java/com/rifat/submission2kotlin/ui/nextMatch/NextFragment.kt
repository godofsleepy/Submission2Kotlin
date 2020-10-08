package com.rifat.submission2kotlin.ui.nextMatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_next.*
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.adapter.MatchAdapter
import com.rifat.submission2kotlin.model.LeagueDetail
import com.rifat.submission2kotlin.model.Match

class NextFragment(private val leagueDetail: LeagueDetail) : Fragment(),NextView {
    private lateinit var presenter: NextPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = NextPresenter(this)
        presenter.getMatch(leagueDetail)
    }

    override fun showLoading() {
        recview_next.visibility = View.INVISIBLE
        progress_next.show()
    }

    fun hideLoading() {
        progress_next.hide()
        recview_next.visibility = View.VISIBLE
    }

    override fun showMatchList(data: List<Match>) {
        recview_next.layoutManager = LinearLayoutManager(context)
        recview_next.adapter = MatchAdapter(data, context)
        hideLoading()
    }
}
