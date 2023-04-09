package com.example.testapplication.model.Teams

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data  class BowlingInPlayerNumber (
    @SerializedName("Style") @Expose val style: String? = null,
    @SerializedName("Average") @Expose val average: String? = null,
    @SerializedName("Economyrate") @Expose val economyrate: String? = null,
    @SerializedName("Wickets") @Expose val wickets: String? = null
): Parcelable
