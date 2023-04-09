package com.example.testapplication.utils

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.model.Teams.Players
import com.example.testapplication.model.Teams.Team
import com.example.testapplication.model.inning.FallofWicket

fun Fragment.LogData(message:String){
    Log.d(this.javaClass.simpleName, "Log -->: "+ message)
}





object Common{
    var teamSelected = ""
    var teamUnselected = ""
    fun getPlayerInfo(seriesDetails: SeriesDetails, batsman: String, team: String) : Players?{
        return seriesDetails.teams.get(team)?.players?.get(batsman)
    }

    fun isDayNight(dayNight : String): String {
        return if ( dayNight.equals("yes")){
            "DayNight"
        }
        else{
            "Day"
        }
    }
}

fun Fragment.follOfData(seriesDetails: SeriesDetails,fallOfWicketList: List<FallofWicket>, team : String ):String{
    var wicketCount = 0
    var fallOfWicket = ""
    for (fallofWickets in fallOfWicketList){
        wicketCount++
        if (fallOfWicket.isEmpty()){
            fallOfWicket = "${fallofWickets.score}/${wicketCount} (${fallofWickets.overs}) [${Common.getPlayerInfo(seriesDetails,fallofWickets.batsman,team)?.nameFull}] "
        }
        else{
            fallOfWicket += ", ${fallofWickets.score}/${wicketCount} (${fallofWickets.overs}) [${Common.getPlayerInfo(seriesDetails,fallofWickets.batsman,team)?.nameFull}] "
        }
    }
    return fallOfWicket
}