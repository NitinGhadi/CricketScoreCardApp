package com.example.testapplication.model.matchDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Venue(
    @SerializedName("Id") @Expose var  id:String,
    @SerializedName("Name") @Expose var   name:String
): Parcelable
