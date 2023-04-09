package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlayerNumber")
data class PlayerNumberEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val position: String? = null,
    val nameFull: String? = null,
    val batting: BattingInPlayerNumberEntity? = null,
    val bowling: BowlingInPlayerNumberEntity? = null,
)
