package com.example.testapplication.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.R
import com.example.testapplication.databinding.AlertDialogPlayerInfoBinding
import com.example.testapplication.databinding.FragmentTeamBinding
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.model.Teams.Players
import com.example.testapplication.utils.*
import com.example.testapplication.view.adapter.BatsmanAdapter
import com.example.testapplication.view.adapter.BowlerAdapter
import com.example.testapplication.viewModel.SeriesDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TeamFragment : Fragment(R.layout.fragment_team) {


    private lateinit var binding: FragmentTeamBinding
    val args: TeamFragmentArgs by navArgs()

    @Inject
    lateinit var batsmanAdapter: BatsmanAdapter

    @Inject
    lateinit var bowlerAdapter: BowlerAdapter

    val seriesDetailsViewModel: SeriesDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var isFirst = args.isFirst

        binding = FragmentTeamBinding.bind(view)

        seriesDetailsViewModel.seriesDetails.observe(viewLifecycleOwner, { dataHandler ->
            when (dataHandler) {
                is DataHandler.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    setValue(dataHandler.data!!)
                }
                is DataHandler.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    LogData("onViewCreated: ERROR " + dataHandler.message)
                }
                is DataHandler.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    LogData("onViewCreated: LOADING..")

                }
            }
        })

        if(isFirst) {
            seriesDetailsViewModel.getIndNzSeriesDetails()
        }
        else{
            seriesDetailsViewModel.getSAPKTMatchDetails()
        }

       //setValue(seriesData!!)
    }


    fun setValue(seriesData : SeriesDetails){
        binding.textSeriesName.text = seriesData.matchDetails.series.name
        binding.textLeague.text = seriesData.matchDetails.match.league
        binding.textMatchDate.text = "${seriesData.matchDetails.match.date} ${seriesData.matchDetails.match.time}"
        binding.textDayNight.text = Common.isDayNight(seriesData.matchDetails.match.daynight)
        binding.textTeamARun.text = "${seriesData.innings[0].total}/${seriesData.innings[0].wickets}\n(${seriesData.innings[0].overs})"
        binding.textTeamBRun.text = "${seriesData.innings[1].total}/${seriesData.innings[1].wickets}\n(${seriesData.innings[1].overs})"
        binding.textTeamAShortName.text = seriesData.teams.get(seriesData.matchDetails.teamAway)?.nameShort
        binding.textTeamBShortName.text = seriesData.teams.get(seriesData.matchDetails.teamHome)?.nameShort
        binding.textResult.text = seriesData.matchDetails.result
        binding.textSeriesNumber.text = seriesData.matchDetails.match.number
        binding.textTeamAName.text = seriesData.teams.get(seriesData.matchDetails.teamAway)?.nameFull
        binding.textTeamBName.text = seriesData.teams.get(seriesData.matchDetails.teamHome)?.nameFull
        binding.textViewMatchPlayer.text = seriesData.matchDetails.playerMatch

        batsmanAdapter.seriesDetails = seriesData
        binding.recycleTeamBatsman.apply {
            adapter = batsmanAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        batsmanAdapter.onBatsmanClicked {
            showDialog(Common.getPlayerInfo(seriesData, it.batsman,Common.teamSelected))
        }

        bowlerAdapter.seriesDetails = seriesData
        binding.recycleTeamBowler.apply {
            adapter = bowlerAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        binding.textTeamAName.setOnClickListener{
            Common.teamSelected =  seriesData.matchDetails.teamAway
            Common.teamUnselected =  seriesData.matchDetails.teamHome
            binding.textTeamAName.setBackgroundColor( Color.LTGRAY )
            binding.textTeamBName.setBackgroundColor( Color.WHITE )
            binding.textLb.text = seriesData.innings.get(0).legbyes
            binding.textW.text = seriesData.innings.get(0).wides
            binding.textNB.text = seriesData.innings.get(0).noballs
            binding.textTotalRun.text = seriesData.innings.get(0).total
            binding.textTotalWikt.text = seriesData.innings.get(0).wickets
            binding.textOv.text = seriesData.innings.get(0).overs
            batsmanAdapter.batsmanList.submitList(seriesData.innings[0].batsmen)
            binding.textFallOfWicket.text = follOfData(seriesData,seriesData.innings[0].fallofWickets,Common.teamSelected)
            bowlerAdapter.bowlerList.submitList((seriesData.innings[0].bowlers))
        }

        binding.textTeamBName.setOnClickListener {
            Common.teamSelected =  seriesData.matchDetails.teamHome
            Common.teamUnselected =  seriesData.matchDetails.teamAway
            binding.textLb.text = seriesData.innings.get(1).legbyes
            binding.textW.text = seriesData.innings.get(1).wides
            binding.textNB.text = seriesData.innings.get(1).noballs
            binding.textTotalRun.text = seriesData.innings.get(1).total
            binding.textTotalWikt.text = seriesData.innings.get(1).wickets
            binding.textOv.text = seriesData.innings.get(1).overs
            binding.textTeamAName.setBackgroundColor( Color.WHITE )
            binding.textTeamBName.setBackgroundColor( Color.LTGRAY )
            batsmanAdapter.batsmanList.submitList(seriesData.innings[1].batsmen)
            binding.textFallOfWicket.text = follOfData(seriesData,seriesData.innings[1].fallofWickets,Common.teamSelected)
            bowlerAdapter.bowlerList.submitList((seriesData.innings[1].bowlers))
        }

        binding.textTeamAName.performClick()

        binding.textVenue.text = seriesData.matchDetails.venue.name


    }


    private fun showDialog(players: Players?){
        val builder = context?.let { AlertDialog.Builder(it) }
        val inflater = LayoutInflater.from(context)
        val binding = AlertDialogPlayerInfoBinding.inflate(inflater)
        builder?.setView(binding.root)

        binding.textBatsmanRuns.text = players?.batting?.runs
        binding.textBatsmanStrikeRate.text = players?.batting?.strikerate
        binding.textBattingAverage.text = players?.batting?.average
        binding.textBattingStyle.text = players?.batting?.style
        binding.textBowlingAverage.text = players?.bowling?.average
        binding.textBowlingStyle.text = players?.bowling?.style
        binding.textBowlingWickets.text = players?.bowling?.wickets
        binding.textBowlingEconomyrateRate.text = players?.bowling?.economyrate
        binding.textPlayerName.text = players?.nameFull
        binding.textPlayerPosition.text = players?.position


        val dialog = builder?.create()
        dialog!!.show()

    }

    private lateinit var onBackPressedCallback: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(
                    R.id.action_teamFragment_to_homeFragment
                )
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }


}