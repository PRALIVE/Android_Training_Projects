package com.example.paging3app.retrofit

import com.example.paging3app.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList
}