package com.rifat.submission2kotlin.ui.detailMatch

import com.rifat.submission2kotlin.api.RetrofitClient
import com.rifat.submission2kotlin.api.RetrofitInterface
import com.rifat.submission2kotlin.model.MatchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMatchPresenter(private val view: DetailMatchView) {
    fun detailget(id: String){


        val retrofit: RetrofitInterface = RetrofitClient().getClient().create(
            RetrofitInterface::class.java)
        val detailCall = retrofit.getDetail(id)
        detailCall.enqueue(object : Callback<MatchResponse>{
            override fun onFailure(call: Call<MatchResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MatchResponse>, response: Response<MatchResponse>) {
                view.ShowMatch(response.body()!!.matchResult[0])
            }
        })



    }
}