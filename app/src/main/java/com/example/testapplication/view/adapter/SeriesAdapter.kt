package com.example.testapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.AdapterSeriesItemBinding
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.model.inning.Batsman
import com.example.testapplication.utils.Common
import javax.inject.Inject

class SeriesAdapter @Inject constructor() : RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    inner class  ViewHolder(var binding: AdapterSeriesItemBinding): RecyclerView.ViewHolder(binding.root)

    private var seriesUtils = object : DiffUtil.ItemCallback<SeriesDetails>(){
        override fun areItemsTheSame(oldItem: SeriesDetails, newItem: SeriesDetails): Boolean {
            return oldItem.teams == newItem.teams
        }

        override fun areContentsTheSame(oldItem: SeriesDetails, newItem: SeriesDetails): Boolean {
            return oldItem == newItem
        }
    }

    var seriesList = AsyncListDiffer(this,seriesUtils)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding= AdapterSeriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return seriesList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var seriesData = seriesList.currentList[position]
        holder.binding.apply {
            textLeague.text = seriesData?.matchDetails?.match?.league
            textResult.text = seriesData?.matchDetails?.result
            textMatchDate.text = "${seriesData?.matchDetails?.match?.date} ${seriesData?.matchDetails?.match?.time}"
            textVenue.text = seriesData?.matchDetails?.venue?.name
            textTeamA.text = seriesData?.teams?.get(seriesData?.matchDetails?.teamAway!!)?.nameFull
            textTeamB.text = seriesData?.teams?.get(seriesData?.matchDetails?.teamHome!!)?.nameFull
            textSeriesNumber.text = seriesData?.matchDetails?.match?.number
            textDayNight.text = Common.isDayNight(seriesData?.matchDetails?.match?.daynight!!)
            textTeamAShortName.text = seriesData?.teams?.get(seriesData?.matchDetails?.teamAway!!)?.nameShort
            textTeamBShortName.text = seriesData?.teams?.get(seriesData?.matchDetails?.teamHome!!)?.nameShort
            textSeriesName.text = seriesData.matchDetails.series.name
        }
        holder.itemView.setOnClickListener {
            setSeriesClickListener?.let {
                it(position == 0)
            }
        }

    }

    private var setSeriesClickListener : ((isFirst: Boolean)->Unit)? =null

    fun onSeriesClicked(listener:(Boolean)->Unit){
        setSeriesClickListener =listener
    }
}