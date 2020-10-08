package com.rifat.submission2kotlin.ui.lastMatch
import com.rifat.submission2kotlin.model.Match

interface LastView {
    fun showLoading()
    fun showMatchList(data: List<Match>)
}