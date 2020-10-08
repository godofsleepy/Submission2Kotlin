package com.rifat.submission2kotlin.search

import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class SearchPresenter(private val view:viewSearch) {

    fun searching(query:String){
        view.showLoading()
        val retrofit: RetrofitInterface = RetrofitClient().getClient().create(
            RetrofitInterface::class.java)

        CompositeDisposable().add(
            retrofit.getMatch(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    view.hideLoading()
                    view.showMatchList(it.searchResult)
                }
        )
    }
}