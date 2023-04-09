package com.example.testapplication.model.Teams

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BattingInPlayerNumber (
    @SerializedName("Style") @Expose val style: String? = null,
    @SerializedName("Average") @Expose val average: String? = null,
    @SerializedName("Strikerate") @Expose val strikerate: String? = null,
    @SerializedName("Runs") @Expose val runs: String? = null
): Parcelable
