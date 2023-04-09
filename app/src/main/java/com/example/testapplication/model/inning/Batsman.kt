package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batsman(
    @SerializedName("Batsman") @Expose var  batsman:String,
    @SerializedName("Runs") @Expose var  runs:String,
    @SerializedName("Balls") @Expose var  balls:String,
    @SerializedName("Fours") @Expose var  fours:String,
    @SerializedName("Sixes") @Expose var  sixes:String,
    @SerializedName("Dots") @Expose var  dots:String,
    @SerializedName("Strikerate") @Expose var  strikerate:String,
    @SerializedName("Dismissal") @Expose var  dismissal:String,
    @SerializedName("Howout") @Expose var  howout:String,
    @SerializedName("Bowler") @Expose var  bowler:String,
    @SerializedName("Fielder") @Expose var fielder:String,
    @SerializedName("Isonstrike") @Expose var  isonstrike:Boolean,
): Parcelable
