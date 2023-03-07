package com.example.navigationdrawerapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationdrawerapp.datamodels.Results
import com.example.navigationdrawerapp.repository.MoviesRepository
import com.example.navigationdrawerapp.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Results>>()
    fun getPopularMovies() {
        val retro = RetrofitInstance().getMoviesApi()
        val repository = MoviesRepository(retro)
        viewModelScope.launch {
            movieLiveData.value = repository.getPopularMovies()
        }
    }
    fun observeMovieLiveData() : LiveData<List<Results>> {
        return movieLiveData
    }
}