package com.example.pagingappv3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.saveddatarecycler.DataAdapter
import com.example.pagingappv3.savedroomdatabase.SavedDao
import kotlinx.coroutines.*

class DatabaseResult : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_database_result, container, false)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerviewf2)
        val database: SavedDao? = MainActivity.roomDao
        var list: List<Article>?
        CoroutineScope(Dispatchers.IO).launch {
            list = database?.getArticles()
            var list2 = ArrayList(list)
          withContext(Dispatchers.Main)  { recyclerview.adapter =
              database?.let { DataAdapter(list2!!, it) }
          }
        }


        return view
    }
}