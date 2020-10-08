package com.rifat.submission2kotlin.ui.lastMatch

import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import com.rifat.submission2kotlin.model.LeagueDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LastPresenter(private val view: LastView) {

    fun getMatch(leagueDetail: LeagueDetail){
        view.showLoading()

        val retrofitI: RetrofitInterface = RetrofitClient().getClient().create(
            RetrofitInterface::class.java)
        CompositeDisposable().add(
            retrofitI.getLastMatch(leagueDetail.idLeague)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    view.showMatchList(it.matchResult)
                }
        )

    }
}