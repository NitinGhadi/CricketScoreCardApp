package com.example.testapplication.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notes (
    @SerializedName("1") @Expose val _1: List<String>? = null,
    @SerializedName("2") @Expose val _2: List<String>? = null
): Parcelable
