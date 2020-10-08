package com.rifat.submission2kotlin.ui.lastMatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.adapter.MatchAdapter
import com.rifat.submission2kotlin.model.LeagueDetail
import com.rifat.submission2kotlin.model.Match
import kotlinx.android.synthetic.main.fragment_last.*

/**
 * A simple [Fragment] subclass.
 */
class LastFragment(private val leagueDetail: LeagueDetail) : Fragment(), LastView {
    private lateinit var presenter: LastPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LastPresenter(this)
        presenter.getMatch(leagueDetail)
    }

    override fun showLoading() {
        recview_last.visibility = View.INVISIBLE
        progress_last.show()
    }

    fun hideLoading() {
        progress_last.hide()
        recview_last.visibility = View.VISIBLE
    }

    override fun showMatchList(data: List<Match>) {
        recview_last.layoutManager = LinearLayoutManager(context)
        recview_last.adapter = MatchAdapter(data, context)
        hideLoading()
    }


}
