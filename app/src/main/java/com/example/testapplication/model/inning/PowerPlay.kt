package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PowerPlay (
    @SerializedName("PP1") @Expose val  pp1:String,
    @SerializedName("PP2") @Expose val  pp2:String
): Parcelable