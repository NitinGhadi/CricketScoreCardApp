package com.example.testapplication.network


import com.example.testapplication.db.entity.*
import com.example.testapplication.model.Teams.*

object Transformer {

    fun convertTeamModelToEntity(teams : Team): TeamsEntity? {
        return null /*TeamsEntity(
            _6 = convertTeamNumberToEntity(teams._6),
            _7 = convertTeamNumberToEntity(teams._7)
        )*/
    }

    private fun convertTeamNumberToEntity(teamNumber: Team): TeamNumberEntity?{

        return null/*TeamNumberEntity(
            nameFull =teamNumber.nameFull,
            nameShort =teamNumber.nameShort,
            players = null
        )*/

    }



    private fun convertPlayerNumberToEntity(playerNumber: Players):PlayerNumberEntity{
        return PlayerNumberEntity(
            position = playerNumber.position,
            nameFull = playerNumber.nameFull,
            batting = convertBattingToEntity(playerNumber.batting),
            bowling = convertBowlingToEntity(playerNumber.bowling)
        )
    }

    private fun convertBattingToEntity(battingInPlayerNumber: BattingInPlayerNumber):BattingInPlayerNumberEntity{
        return BattingInPlayerNumberEntity(
             style = battingInPlayerNumber.style,
             average = battingInPlayerNumber.average,
             strikerate = battingInPlayerNumber.strikerate,
             runs = battingInPlayerNumber.runs
        )
    }

    private fun  convertBowlingToEntity(bowlingInPlayerNumber: BowlingInPlayerNumber) : BowlingInPlayerNumberEntity{
        return BowlingInPlayerNumberEntity(
            average = bowlingInPlayerNumber.average,
            style = bowlingInPlayerNumber.style,
            economyrate = bowlingInPlayerNumber.economyrate,
            wickets = bowlingInPlayerNumber.wickets
        )
    }
}