package com.example.pagingappv3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagingappv3.paging.NewsPagingSource
import com.example.pagingappv3.retrofit.ApiMethods
import com.example.pagingappv3.roomdatabase.RoomDao
import javax.inject.Inject

class NewsRepository (val newsapi : ApiMethods, val db:RoomDao) {

    fun getNews() = Pager(
       config = PagingConfig(pageSize = 1, maxSize = 10),
       pagingSourceFactory = {NewsPagingSource(newsapi,db)}
    ).liveData
}