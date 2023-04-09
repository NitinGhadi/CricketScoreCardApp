package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BatsmanPartnership(
    @SerializedName("Batsman") @Expose var  batsman:String,
    @SerializedName("Runs") @Expose var runs:String,
    @SerializedName("Balls") @Expose var balls:String
): Parcelable
