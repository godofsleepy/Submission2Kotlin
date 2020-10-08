package com.rifat.submission2kotlin.ui.nextMatch

import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import com.rifat.submission2kotlin.model.LeagueDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NextPresenter(private val view: NextView) {

    fun getMatch(leagueDetail: LeagueDetail){
        view.showLoading()

            val retrofit: RetrofitInterface = RetrofitClient().getClient().create(
                RetrofitInterface::class.java)

            CompositeDisposable().add(
            retrofit.getNextMatch(leagueDetail.idLeague)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    view.showMatchList(it.matchResult)
                }
            )
    }
}