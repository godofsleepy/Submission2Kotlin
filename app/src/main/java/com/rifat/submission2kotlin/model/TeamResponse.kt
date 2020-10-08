package com.rifat.submission2kotlin.model

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("teams")
    val teamResult: List<Team>?
)

data class Team(
    @SerializedName("strTeamBadge")
    val teamImage: String?
)

data class RawTeamResponse(
    val teamHome: TeamResponse,
    val teamAway: TeamResponse
)