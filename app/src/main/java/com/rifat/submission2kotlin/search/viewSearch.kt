package com.rifat.submission2kotlin.search

import com.rifat.submission2kotlin.model.Match

interface viewSearch {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Match>?)
}