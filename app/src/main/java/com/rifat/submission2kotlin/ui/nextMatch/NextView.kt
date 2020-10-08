package com.rifat.submission2kotlin.ui.nextMatch
import com.rifat.submission2kotlin.model.Match

interface NextView {
    fun showLoading()
    fun showMatchList(data: List<Match>)
}