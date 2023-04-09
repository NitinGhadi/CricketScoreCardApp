package com.example.testapplication.view.adapter

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.AdapterBatsmanItemBinding
import com.example.testapplication.model.SeriesDetails

import com.example.testapplication.model.inning.Batsman
import com.example.testapplication.utils.Common
import javax.inject.Inject

class BatsmanAdapter @Inject constructor() : RecyclerView.Adapter<BatsmanAdapter.ViewHolder>() {
    var seriesDetails: SeriesDetails ?= null
    fun sendSeriesData(seriesDetails: SeriesDetails){
        this.seriesDetails = seriesDetails
    }


    inner class  ViewHolder(val binding: AdapterBatsmanItemBinding): RecyclerView.ViewHolder(binding.root)

    private var batsmanUtil = object : DiffUtil.ItemCallback<Batsman>(){
        override fun areItemsTheSame(oldItem: Batsman, newItem: Batsman): Boolean {
            return oldItem.batsman == newItem.batsman
        }

        override fun areContentsTheSame(oldItem: Batsman, newItem: Batsman): Boolean {
            return oldItem == newItem
        }

    }

    var batsmanList = AsyncListDiffer(this, batsmanUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatsmanAdapter.ViewHolder {
        val binding = AdapterBatsmanItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BatsmanAdapter.ViewHolder, position: Int) {
        val batsmanData = batsmanList.currentList[position]
        holder.binding.apply {
            textBatsmanName.text = Common.getPlayerInfo( seriesDetails!!, batsmanData.batsman,Common.teamSelected)?.nameFull
            textBatsmanNoOfSix.text = batsmanData.sixes
            textBatsmanNoOfFour.text = batsmanData.fours
            textBatsmanRun.text = batsmanData.runs
            textBatsmanStrikeRate.text = batsmanData.strikerate
            textBatsmanHowOut.text = batsmanData.howout
            textBatsmanBallTaken.text = batsmanData.balls
            if(Common.getPlayerInfo( seriesDetails!!, batsmanData.batsman,Common.teamSelected)?.isCaptain!!){
                textBatsmanIsCaptain.visibility = View.VISIBLE
            }
            else{
                textBatsmanIsCaptain.visibility = View.GONE
            }
            if(Common.getPlayerInfo( seriesDetails!!, batsmanData.batsman,Common.teamSelected)?.isKeeper!!){
                textBatsmankiper.visibility = View.VISIBLE
            }
            else{
                textBatsmankiper.visibility = View.GONE
            }
        }

        holder.itemView.setOnClickListener {
            setBatsmanClickListener?.let {
                it(batsmanData)
            }
        }
    }

    override fun getItemCount(): Int {
        return batsmanList.currentList.size
    }

    private var setBatsmanClickListener : ((batsman: Batsman)->Unit)? =null

    fun onBatsmanClicked(listener:(Batsman)->Unit){
        setBatsmanClickListener =listener
    }


}
