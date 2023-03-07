package com.example.navigationdrawerapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.navigationdrawerapp.datamodels.Results
import com.example.navigationdrawerapp.retrofit.MoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(val movieapi : MoviesApi) {

    suspend fun getPopularMovies() : List<Results>{
       val response = movieapi.getPopularMovies("2b050e170697c74b36ea255ffb37073c")
        return response.results
    }
}