package com.example.testapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.model.SeriesDetails
import com.example.testapplication.network.DBRepository
import com.example.testapplication.network.NetworkRepository
import com.example.testapplication.utils.DataHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SeriesDetailsViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val dbRepository: DBRepository
): ViewModel() {
    private val _SeriesDetails = MutableLiveData<DataHandler<SeriesDetails>>()
    var seriesDetails: LiveData<DataHandler<SeriesDetails>> = _SeriesDetails

    fun getIndNzSeriesDetails(){
        _SeriesDetails.postValue(DataHandler.LOADING())
        viewModelScope.launch {
            val response = networkRepository.getIndZNMatchDetails()
            //dbRepository.insertArticle(response.body()!!.teams)
            _SeriesDetails.postValue(handleResponse(response))
        }
    }

    fun getSAPKTMatchDetails(){
        _SeriesDetails.postValue(DataHandler.LOADING())
        viewModelScope.launch {
            val response = networkRepository.getSAPKTMatchDetails()
            //dbRepository.insertArticle(response.body()!!.teams)
            _SeriesDetails.postValue(handleResponse(response))
        }
    }

    private fun handleResponse(response: Response<SeriesDetails>): DataHandler<SeriesDetails> {
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return DataHandler.SUCCESS(it)
            }
        }
        return DataHandler.ERROR(message = response.errorBody().toString())
    }
}