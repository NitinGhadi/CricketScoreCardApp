package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Inning(
    @SerializedName("Number") @Expose var  number:String,
    @SerializedName("Battingteam") @Expose var battingteam:String,
    @SerializedName("Total") @Expose var  total:String,
    @SerializedName("Wickets") @Expose var  wickets:String,
    @SerializedName("Overs") @Expose var overs:String,
    @SerializedName("Runrate") @Expose var  runrate:String,
    @SerializedName("Byes") @Expose var  byes:String,
    @SerializedName("Legbyes") @Expose var  legbyes:String,
    @SerializedName("Wides") @Expose var  wides:String,
    @SerializedName("Noballs") @Expose var  noballs:String,
    @SerializedName("Penalty") @Expose var penalty:String,
    @SerializedName("AllottedOvers") @Expose var allottedOvers:String,
    @SerializedName("Batsmen")  @Expose var  batsmen:List<Batsman>,
    @SerializedName("Partnership_Current") @Expose var partnershipCurrent:PartnershipCurrent,
    @SerializedName("Bowlers") @Expose var  bowlers:List<Bowlers> = ArrayList<Bowlers>(),
    @SerializedName("FallofWickets") @Expose var fallofWickets:List<FallofWicket>,
    @SerializedName("PowerPlay") @Expose var  powerPlay:PowerPlay,
    @SerializedName("Target") @Expose var target:String,
): Parcelable