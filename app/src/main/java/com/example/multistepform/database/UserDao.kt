package com.example.multistepform.database

import androidx.room.*
import com.example.multistepform.datamodels.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getArticles() : List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(data: User)

    @Query("SELECT * FROM User WHERE primaryKey = :userId")
    fun getUserById(userId: Int): User?

    @Update
    fun updateUser(user: User)

    @Delete
    fun delete(article:User)
}