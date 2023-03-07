package com.example.mvvm_architecture.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_architecture.datamodels.Movies
import com.example.mvvm_architecture.datamodels.Results
import com.example.mvvm_architecture.retrofit.MoviesApi
import com.example.mvvm_architecture.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(val movieapi : MoviesApi) {

    suspend fun getPopularMovies() : List<Results>{
       val response = movieapi.getPopularMovies("2b050e170697c74b36ea255ffb37073c")
        return response.results
    }
}