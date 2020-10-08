package com.rifat.submission2kotlin.ui.detailLeague

import com.rifat.submission2kotlin.model.LeagueDetail

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: LeagueDetail)
}