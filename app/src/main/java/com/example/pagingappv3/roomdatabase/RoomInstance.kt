package com.example.pagingappv3.roomdatabase

import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomInstance (var db : myroomDatabase){
//
//    @Singleton
//    @Provides
//    fun getRoom() : RoomDao{
//        return db.roomDao()
//    }
}