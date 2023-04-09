package com.example.testapplication.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.testapplication.db.entity.TeamsEntity

@Dao
interface TeamsDao {
    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( teams: TeamsEntity): Long

    @Delete
    suspend fun delete( teams: TeamsEntity)
}
