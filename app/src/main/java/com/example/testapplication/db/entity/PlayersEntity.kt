package com.example.testapplication.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Players" )
data class PlayersEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val _2734: PlayerNumberEntity,
    val  _3472: PlayerNumberEntity,
    val _4038: PlayerNumberEntity,
    val _57492: PlayerNumberEntity,
    val _59429: PlayerNumberEntity,
    val _63084: PlayerNumberEntity,
    val _64073: PlayerNumberEntity,
    val _64306: PlayerNumberEntity,
    val _64321: PlayerNumberEntity,
    val _65739: PlayerNumberEntity,
    val  _66833: PlayerNumberEntity,

    val  _3667: PlayerNumberEntity,
    val  _4356: PlayerNumberEntity,
    val  _5313: PlayerNumberEntity,
    val  _12518: PlayerNumberEntity,
    val  _24669: PlayerNumberEntity,
    val  _28891: PlayerNumberEntity,
    val  _48191: PlayerNumberEntity,
    val  _57458: PlayerNumberEntity,
    val  _59736: PlayerNumberEntity,
    val  _63611: PlayerNumberEntity,
    val  _64221: PlayerNumberEntity
)