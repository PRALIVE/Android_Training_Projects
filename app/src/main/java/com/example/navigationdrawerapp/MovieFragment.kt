package com.example.navigationdrawerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawerapp.adapter.MovieAdapter
import com.example.navigationdrawerapp.databinding.FragmentMovieBinding
import com.example.navigationdrawerapp.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var recyclerview : RecyclerView
    lateinit var binding: FragmentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view :View = inflater.inflate(R.layout.fragment_movie, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
        binding = FragmentMovieBinding.inflate(layoutInflater)
        view = binding.root
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer {
            movieAdapter.setMovieList(it)
        })



        return view
    }

    fun prepareRecyclerView(){
        movieAdapter = MovieAdapter()
        binding.recyclerview.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = movieAdapter
        }

    }
}