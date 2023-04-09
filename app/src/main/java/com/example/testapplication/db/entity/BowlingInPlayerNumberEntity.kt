package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BowlingInPlayerNumber")
data  class BowlingInPlayerNumberEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val style: String? = null,
    val average: String? = null,
    val economyrate: String? = null,
    val wickets: String? = null
)
