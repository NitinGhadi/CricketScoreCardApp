package com.example.testapplication.model.matchDetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Series(
    @SerializedName("Id") @Expose var  id:String,
    @SerializedName("Name") @Expose var  name:String,
    @SerializedName("Status") @Expose var  status:String,
    @SerializedName("Tour") @Expose var  tour:String,
    @SerializedName("Tour_Name") @Expose var  tourName:String
): Parcelable
