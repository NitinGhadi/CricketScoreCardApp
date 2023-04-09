package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FallofWicket (
    @SerializedName("Batsman") @Expose val  batsman:String,
    @SerializedName("Score") @Expose val  score:String,
    @SerializedName("Overs") @Expose val overs:String
): Parcelable
