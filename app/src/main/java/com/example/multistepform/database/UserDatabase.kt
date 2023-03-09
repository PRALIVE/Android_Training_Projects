package com.example.multistepform.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.multistepform.datamodels.User


@Database(entities = [User::class], version = 3, exportSchema = false)
 abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}