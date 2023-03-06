package com.example.pagingappv3.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.models.NewsResponse

@Database(entities = [NewsResponse::class], version = 5, exportSchema = false)
@TypeConverters(SourceTypeConverter::class, arrayconvertor::class)
abstract class myroomDatabase : RoomDatabase(){
    abstract fun roomDao() : RoomDao
}