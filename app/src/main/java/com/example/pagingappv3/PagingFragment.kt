package com.example.pagingappv3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.paging.NewsLoadingAdapter
import com.example.pagingappv3.paging.NewsPagingAdapter
import com.example.pagingappv3.roomdatabase.myroomDatabase
import com.example.pagingappv3.savedroomdatabase.SavedDao
import com.example.pagingappv3.savedroomdatabase.SavedDatabase
import com.example.pagingappv3.viemodel.NewsViewModel

class PagingFragment() : Fragment() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: NewsPagingAdapter
    private lateinit var newsviewmodel: NewsViewModel
    private lateinit var saved : List<Article>
    public lateinit var database : SavedDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_paging, container, false)

        val room = Room.databaseBuilder(
            requireContext(),
            SavedDatabase::class.java,"SavedArticles"
        ).fallbackToDestructiveMigration().build()
        val roomdao = room.savedDao()
        MainActivity.roomDao=roomdao
        database = roomdao

        recyclerview = view.findViewById(R.id.recyclerviewf1)
        adapter = NewsPagingAdapter(roomdao)
        newsviewmodel = ViewModelProvider(requireActivity())[NewsViewModel::class.java]


        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter.withLoadStateHeaderAndFooter(
            header = NewsLoadingAdapter(),
            footer = NewsLoadingAdapter()
        )

        newsviewmodel.list.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }
        return view

    }
}