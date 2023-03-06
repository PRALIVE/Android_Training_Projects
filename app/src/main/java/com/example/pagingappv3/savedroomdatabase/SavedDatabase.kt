package com.example.pagingappv3.savedroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.models.NewsResponse
import com.example.pagingappv3.roomdatabase.RoomDao
import com.example.pagingappv3.roomdatabase.SourceTypeConverter
import com.example.pagingappv3.roomdatabase.arrayconvertor

@Database(entities = [Article::class], version = 8, exportSchema = false)
@TypeConverters(SourceTypeConverter::class)
abstract class SavedDatabase : RoomDatabase() {
    abstract fun savedDao() : SavedDao
}