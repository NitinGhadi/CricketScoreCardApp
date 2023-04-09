package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Teams")
data class TeamsEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val _6: TeamNumberEntity,
    val _7: TeamNumberEntity
)
