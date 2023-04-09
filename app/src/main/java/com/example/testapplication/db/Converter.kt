package com.example.testapplication.db

import androidx.room.TypeConverter
import com.example.testapplication.db.entity.TeamNumberEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    val gson = Gson()

    @TypeConverter
    fun toTeamNumberEntityToString(entity: TeamNumberEntity): String {
        val type = object : TypeToken<TeamNumberEntity>() {}.type
        return gson.toJson(entity, type)
    }

    @TypeConverter
    fun fromStringToEntity(string: String): TeamNumberEntity {
        val type = object : TypeToken<TeamNumberEntity>() {}.type
        return gson.fromJson<TeamNumberEntity>(string, type)

    }

}