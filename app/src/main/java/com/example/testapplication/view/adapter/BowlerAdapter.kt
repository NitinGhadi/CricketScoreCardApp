package com.example.testapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.AdapterBowlerItemBinding
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.model.inning.Bowlers
import com.example.testapplication.utils.Common
import javax.inject.Inject

class BowlerAdapter @Inject constructor() : RecyclerView.Adapter<BowlerAdapter.ViewHolder>() {
    var seriesDetails: SeriesDetails?= null
    fun sendSeriesData(seriesDetails: SeriesDetails){
        this.seriesDetails = seriesDetails
    }

    inner class ViewHolder(var binding: AdapterBowlerItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var bowlerUtils = object : DiffUtil.ItemCallback<Bowlers>(){
        override fun areItemsTheSame(oldItem: Bowlers, newItem: Bowlers): Boolean {
            return oldItem.bowler == newItem.bowler
        }

        override fun areContentsTheSame(oldItem: Bowlers, newItem: Bowlers): Boolean {
            return oldItem == newItem
        }
    }

    var bowlerList = AsyncListDiffer(this,bowlerUtils)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding= AdapterBowlerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return bowlerList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var bowlerData = bowlerList.currentList[position]
        holder.binding.apply {
            textBowlerName.text = Common.getPlayerInfo(seriesDetails!!,bowlerData.bowler,Common.teamUnselected)?.nameFull
            textBowlerOver.text = bowlerData.overs
            textBowlerMaiden.text = bowlerData.maidens
            textBowlerRun.text = bowlerData.runs
            textBowlerWicket.text = bowlerData.wickets
            textBowlerEcon.text = bowlerData.economyrate
        }
    }


}
