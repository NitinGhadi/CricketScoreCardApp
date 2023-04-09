package com.example.testapplication.model.matchDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MatchDetail(
    @SerializedName("Team_Home") @Expose var teamHome:String,
    @SerializedName("Team_Away") @Expose var teamAway:String,
    @SerializedName("Match")  @Expose var match: Match,
    @SerializedName("Series") @Expose var series: Series,
    @SerializedName("Venue")  @Expose var venue: Venue,
    @SerializedName("Officials") @Expose var officials: Officials,
    @SerializedName("Weather") @Expose var weather:String,
    @SerializedName("Tosswonby") @Expose var tosswonby:String,
    @SerializedName("Status") @Expose var status:String,
    @SerializedName("Status_Id") @Expose var statusId:String,
    @SerializedName("Player_Match") @Expose  val playerMatch:String,
    @SerializedName("Result") @Expose var  result:String,
    @SerializedName("Winningteam") @Expose var winningteam:String,
    @SerializedName("Winmargin") @Expose var winmargin:String,
    @SerializedName("Equation") @Expose var equation:String
): Parcelable