package com.example.pagingappv3.roomdatabase

import androidx.room.*
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.models.NewsResponse

@Dao
interface RoomDao {
    @Query("SELECT * FROM NewsResponse")
   suspend fun getAll() : List<NewsResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(newsResponse: NewsResponse)
}