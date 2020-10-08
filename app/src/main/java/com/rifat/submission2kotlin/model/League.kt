package com.rifat.submission2kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val idLeague:String?,
    val leagueName:String?,
    val imageLeague:Int?
):Parcelable