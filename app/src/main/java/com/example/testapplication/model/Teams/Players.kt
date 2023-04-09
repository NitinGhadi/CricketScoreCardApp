package com.example.testapplication.model.Teams

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players (
    @SerializedName("Position") @Expose val position: String? = null,
    @SerializedName("Name_Full") @Expose val nameFull: String? = null,
    @SerializedName("Batting") @Expose val batting: BattingInPlayerNumber,
    @SerializedName("Bowling") @Expose val bowling: BowlingInPlayerNumber,
    @SerializedName("Iscaptain") @Expose val isCaptain: Boolean,
    @SerializedName("Iskeeper") @Expose val isKeeper: Boolean,
): Parcelable
