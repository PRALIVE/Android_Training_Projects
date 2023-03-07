package com.example.navigationdrawerapp.retrofit

import com.example.navigationdrawerapp.datamodels.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("popular?")
    suspend fun getPopularMovies(@Query("api_key") api_key : String) : Movies
}