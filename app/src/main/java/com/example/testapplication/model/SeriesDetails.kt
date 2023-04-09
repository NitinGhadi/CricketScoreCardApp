package com.example.testapplication.model

import android.os.Parcelable
import com.example.testapplication.model.Teams.Team
import com.example.testapplication.model.inning.Inning
import com.example.testapplication.model.matchDetail.MatchDetail
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriesDetails(
    @SerializedName("Matchdetail") @Expose var matchDetails: MatchDetail,
    @SerializedName("Nuggets") @Expose var nuggets: List<String>,
    @SerializedName("Innings") @Expose var innings: List<Inning>,
    @SerializedName("Teams") @Expose var teams: Map<String, Team>,
    @SerializedName("Notes") @Expose var notes: Notes
):Parcelable
