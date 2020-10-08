package com.rifat.submission2kotlin.ui.detailLeague

import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import com.rifat.submission2kotlin.model.League
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class DetailPresenter(private val view:DetailView) {

    fun getLeagueDetail(league: League){
        view.showLoading()
        val retrofit: RetrofitInterface = RetrofitClient().getClient().create(RetrofitInterface::class.java)

        CompositeDisposable().add(
            retrofit.getLeague(league.idLeague)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe
                {
                    view.hideLoading()
                    view.showTeamList(it.leagueResult[0])
                }

        )
        }
}


