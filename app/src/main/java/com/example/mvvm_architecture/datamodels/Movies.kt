package com.example.mvvm_architecture.datamodels

data class Movies(
    val page: Int,
    val results: List<Results>,
    val total_pages: Int,
    val total_results: Int
)
