package com.example.testapplication.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentHomeBinding
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.utils.DataHandler
import com.example.testapplication.utils.LogData
import com.example.testapplication.utils.isOnline
import com.example.testapplication.view.adapter.SeriesAdapter
import com.example.testapplication.viewModel.SeriesDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    val seriesDetailsViewModel: SeriesDetailsViewModel by viewModels()

    @Inject
    lateinit var seriesAdapter: SeriesAdapter

    val arrayList = ArrayList<SeriesDetails>()

    var isFirstApiLoad : Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding  = FragmentHomeBinding.bind(view)




        checkIsOnline()
        init()
    }

    fun checkIsOnline(){
        if(isOnline(requireActivity())) {
            fragmentHomeBinding.OfflineView.visibility = View.GONE
            liveCall()
        }
        else{
            fragmentHomeBinding.OfflineView.visibility = View.VISIBLE
        }
    }

    fun liveCall(){
        // calling frist InZn api then SAPAK api
        seriesDetailsViewModel.seriesDetails.observe(viewLifecycleOwner, { dataHandler ->
            when (dataHandler) {
                is DataHandler.SUCCESS -> {
                    if(isFirstApiLoad){
                        isFirstApiLoad = false
                        seriesDetailsViewModel.getSAPKTMatchDetails()
                        arrayList.add(dataHandler.data!!)
                    }
                    else{
                        fragmentHomeBinding.progressBar.visibility = View.GONE
                        arrayList.add(dataHandler.data!!)
                        setValue()
                    }
                }
                is DataHandler.ERROR -> {
                    if(isFirstApiLoad){
                        isFirstApiLoad = false
                    }
                    else{
                        setValue()
                    }
                    fragmentHomeBinding.progressBar.visibility = View.GONE
                    LogData("onViewCreated: ERROR " + dataHandler.message)
                }
                is DataHandler.LOADING -> {
                    fragmentHomeBinding.progressBar.visibility = View.VISIBLE
                    LogData("onViewCreated: LOADING..")

                }
            }
        })


        seriesDetailsViewModel.getIndNzSeriesDetails()
        isFirstApiLoad = true
    }

    fun setValue(){
        seriesAdapter.seriesList.submitList((arrayList))
    }
    
    fun init(){
        fragmentHomeBinding.recycleSeriesList.apply {
            adapter = seriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        seriesAdapter.onSeriesClicked {
            val bundle = Bundle().apply {
                putBoolean( "isFirst" ,it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_teamFragment,
                bundle
            )
        }


        fragmentHomeBinding.btnReTry.setOnClickListener{
            checkIsOnline()
        }
    }


}