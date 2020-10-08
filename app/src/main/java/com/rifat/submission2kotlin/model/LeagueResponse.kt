package com.rifat.submission2kotlin.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse (
    @SerializedName("leagues")
    val leagueResult: List<LeagueDetail>
)


data class LeagueDetail (
    @SerializedName("idLeague")
    val idLeague: String?,

    @SerializedName("strLeague")
    val name: String?,

    @SerializedName("strDescriptionEN")
    val description: String?,

    @SerializedName("strCountry")
    val country: String?,

    @SerializedName("strWebsite")
    val website: String?
)