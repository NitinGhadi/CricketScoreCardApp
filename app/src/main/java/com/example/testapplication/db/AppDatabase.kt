package com.example.testapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testapplication.db.dao.TeamsDao
import com.example.testapplication.db.entity.TeamsEntity

@Database(
    version = 1,
    entities = [ TeamsEntity::class],
)
@TypeConverters(Converter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun teamDao(): TeamsDao
}