package com.example.testapplication.model.matchDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Match(
    @SerializedName("Livecoverage") @Expose var  livecoverage:String,
    @SerializedName("Id") @Expose  var  id:String,
    @SerializedName("Code") @Expose var code:String,
    @SerializedName("League") @Expose var league:String,
    @SerializedName("Number") @Expose var  number:String,
    @SerializedName("Type") @Expose var type:String,
    @SerializedName("Date") @Expose var date:String,
    @SerializedName("Time") @Expose var  time:String,
    @SerializedName("Offset") @Expose var  offset:String,
    @SerializedName("Daynight") @Expose var  daynight:String
): Parcelable
