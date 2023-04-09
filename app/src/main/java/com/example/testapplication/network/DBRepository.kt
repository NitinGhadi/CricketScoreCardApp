package com.example.testapplication.network

import com.example.testapplication.db.AppDatabase
import javax.inject.Inject

class DBRepository @Inject constructor(val appDatabase: AppDatabase) {

   /* suspend fun insertArticle(teams: Teams): Long {
        return appDatabase.teamDao()
            .insert(convertTeamModelToEntity(teams))
    }*/

    /*suspend fun delete(teams: Teams) {
        appDatabase.teamDao().delete(convertTeamModelToEntity(teams))
    }*/



}