package com.example.testapplication.model.inning

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThisOver (
    @SerializedName("T") @Expose val  _tSomethis:String,
    @SerializedName("B") @Expose val  _bsomethis:String
    ): Parcelable
