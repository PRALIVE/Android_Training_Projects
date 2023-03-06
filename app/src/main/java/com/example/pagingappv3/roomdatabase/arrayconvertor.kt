package com.example.pagingappv3.roomdatabase

import androidx.room.TypeConverter
import com.example.pagingappv3.models.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class arrayconvertor {

    @TypeConverter
    fun fromString(value: String?): List<Article?>? {
        val listType: Type = object : TypeToken<List<Article?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Article?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}