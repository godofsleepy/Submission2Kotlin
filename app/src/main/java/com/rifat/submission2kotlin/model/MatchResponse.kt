package com.rifat.submission2kotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MatchResponse (
    @SerializedName("events")
    val matchResult : List<Match>
)

data class SearchResponse(
    @SerializedName("event")
    val searchResult: List<Match>
)

@Parcelize
data class Match(
    @SerializedName("idEvent")
    val idMatch: String?,

    @SerializedName("strEvent")
    val matchName: String?,

    @SerializedName("strDate")
    val matchDate: String?,

    @SerializedName("strSport")
    val sport:String?,

    @SerializedName("strTime")
    val matchTime: String?,

    @SerializedName("intHomeScore")
    val homeScore: String?,

    @SerializedName("intAwayScore")
    val awayScore: String?,

    @SerializedName("strHomeTeam")
    val homeTeam: String?,

    @SerializedName("strAwayTeam")
    val awayTeam: String?,

    @SerializedName("idHomeTeam")
    val idHomeTeam: String?,

    @SerializedName("idAwayTeam")
    val idAwayTeam: String?,

    @SerializedName("strHomeGoalDetails")
    val homeGoalDetail: String?,

    @SerializedName("strAwayGoalDetails")
    val awayGoalDetail: String?,

    @SerializedName("strHomeRedCards")
    val homeRedCard:String?,

    @SerializedName("strHomeYellowCards")
    val homeYellowCard:String?,

    @SerializedName("strAwayRedCards")
    val awayRedCard: String?,

    @SerializedName("strAwayYellowCards")
    val awayYellowCard: String?,

    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper : String?,

    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense : String?,

    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield : String?,

    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward : String?,

    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes : String?,

    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper : String?,

    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense : String?,

    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield : String?,

    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward : String?,

    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes : String?
):Parcelable
