package com.example.newretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {
    var source :Source = Source("ff","fdfdfg")
    public var art:List<Articles> = listOf(Articles(source,"dfff","ffgfh","dfgh","fdgdhg","ffgdfgdg","vgdfggh","ghfghfg"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val service = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserResponseI::class.java)


        service.getData().enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("failures", "An error happened!")
            }
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val res = response.body()
                res?.status?.let { Log.d("responses", it) }
                res?.articles?.let {
                    val adapter = CustomAdapter(it)
                    recyclerView.adapter = adapter
                }
            }
        })
//        val adapter = CustomAdapter(art)
//        recyclerView.adapter = adapter
    }
}

interface UserResponseI{
    @GET("/v2/everything?q=tesla&page=1&pageSize=20&from=2023-01-20&sortBy=publishedAt&apiKey=4d5281ab72264bc093cf29cef19f3de4")
    fun getData() : Call<Data>
}
