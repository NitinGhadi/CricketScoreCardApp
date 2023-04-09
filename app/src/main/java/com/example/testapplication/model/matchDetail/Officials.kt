package com.example.testapplication.model.matchDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Officials(
    @SerializedName("Umpires") @Expose var  umpires:String,
    @SerializedName("Referee") @Expose var  referee:String
): Parcelable
