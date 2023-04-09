package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "BattingInPlayerNumber")
data class BattingInPlayerNumberEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val style: String? = null,
    val average: String? = null,
    val strikerate: String? = null,
    val runs: String? = null
)
