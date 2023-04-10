package com.example.testapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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

fun Fragment.isOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
    }
    return false
}