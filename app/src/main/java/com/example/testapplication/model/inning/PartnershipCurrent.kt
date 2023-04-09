package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PartnershipCurrent(
    @SerializedName("Runs") @Expose var runs:String,
    @SerializedName("Balls") @Expose  var balls:String,
    @SerializedName("Batsmen") @Expose var batsmen:List<BatsmanPartnership>
): Parcelable
