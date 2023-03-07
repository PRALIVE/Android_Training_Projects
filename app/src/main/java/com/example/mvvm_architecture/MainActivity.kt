package com.example.mvvm_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_architecture.adapter.MovieAdapter
import com.example.mvvm_architecture.databinding.ActivityMainBinding
import com.example.mvvm_architecture.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var recyclerview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer {
            movieAdapter.setMovieList(it)
        })

    }

    fun prepareRecyclerView(){
        movieAdapter = MovieAdapter()
        binding.recyclerview.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }

    }
}