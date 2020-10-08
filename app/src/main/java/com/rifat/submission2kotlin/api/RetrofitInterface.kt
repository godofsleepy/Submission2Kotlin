package com.rifat.submission2kotlin.api

import com.rifat.submission2kotlin.model.LeagueResponse
import com.rifat.submission2kotlin.model.MatchResponse
import com.rifat.submission2kotlin.model.SearchResponse
import com.rifat.submission2kotlin.model.TeamResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {
    @GET("api/v1/json/1/lookupleague.php")
    fun getLeague(@Query("id") id:String?): Observable<LeagueResponse>

    @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") id:String?): Observable<MatchResponse>

    @GET("api/v1/json/1/eventspastleague.php")
    fun getLastMatch(@Query("id") id:String?): Observable<MatchResponse>

    @GET("api/v1/json/1/lookupteam.php")
    fun getTeam(@Query("id") id: String?): Observable<TeamResponse>

    @GET("api/v1/json/1/searchevents.php")
    fun  getMatch(@Query("e") e:String?) : Observable<SearchResponse>

    @GET("api/v1/json/1/lookupevent.php")
    fun getDetail(@Query("id")id :String?): Call<MatchResponse>
}