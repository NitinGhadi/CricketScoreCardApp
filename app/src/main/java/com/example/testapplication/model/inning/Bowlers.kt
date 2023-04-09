package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Bowlers(
    @SerializedName("Bowler") @Expose val  bowler:String,
    @SerializedName("Overs") @Expose val  overs:String,
    @SerializedName("Maidens") @Expose val  maidens:String,
    @SerializedName("Runs") @Expose val  runs:String,
    @SerializedName("Wickets") @Expose val  wickets:String ,
    @SerializedName("Economyrate") @Expose val  economyrate : String,
    @SerializedName("Noballs") @Expose val  noballs:String ,
    @SerializedName("Wides") @Expose val  wides:String ,
    @SerializedName("Dots") @Expose val  dots:String ,
    @SerializedName("Isbowlingtandem") @Expose val  isbowlingtandem:Boolean,
    @SerializedName("Isbowlingnow") @Expose val isbowlingnow:Boolean ,
    @SerializedName("ThisOver") @Expose val thisOver:List<ThisOver> = ArrayList<ThisOver>()
): Parcelable

