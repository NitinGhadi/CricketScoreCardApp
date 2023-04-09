package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TeamNumber")
data class TeamNumberEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val  nameFull:String,
    val  nameShort:String,
    val  players: PlayersEntity
)
