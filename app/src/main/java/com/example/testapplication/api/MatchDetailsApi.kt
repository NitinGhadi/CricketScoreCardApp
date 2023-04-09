package com.example.testapplication.api

import com.example.testapplication.model.SeriesDetails
import retrofit2.Response
import retrofit2.http.GET

interface MatchDetailsApi {

    @GET("nzin01312019187360.json")
    suspend fun getIndZNMatchDetails(): Response<SeriesDetails>

    @GET("sapk01222019186652.json")
    suspend fun getSAPKTMatchDetails(): Response<SeriesDetails>
}