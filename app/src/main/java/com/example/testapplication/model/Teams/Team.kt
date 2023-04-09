package com.example.testapplication.model.Teams

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    @SerializedName("Name_Full") @Expose val  nameFull:String,
    @SerializedName("Name_Short") @Expose var  nameShort:String,
    @SerializedName("Players") @Expose var  players:Map<String, Players>
): Parcelable
