package com.example.testapplication.network

import com.example.testapplication.api.MatchDetailsApi
import com.example.testapplication.model.SeriesDetails
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val matchDetailsApi: MatchDetailsApi
) {
    suspend fun getSAPKTMatchDetails(): Response<SeriesDetails>{
        return matchDetailsApi.getSAPKTMatchDetails()
    }

    suspend fun getIndZNMatchDetails(): Response<SeriesDetails>{
        return matchDetailsApi.getIndZNMatchDetails()
    }
}