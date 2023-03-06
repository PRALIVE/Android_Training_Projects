package com.example.pagingappv3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsResponse(
    @PrimaryKey var page: Int,
    @ColumnInfo(name = "articles") val articles: List<Article>,
    @ColumnInfo(name = "totalResults") val totalResults: Int
)