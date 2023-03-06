package com.example.pagingappv3

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagingappv3.broadcastreceiver.AeroplaneModeReceiver
import com.example.pagingappv3.savedroomdatabase.SavedDao
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private val fragmentManager = supportFragmentManager
    lateinit var receiver : AeroplaneModeReceiver

    companion object {
        var roomDao: SavedDao? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, PagingFragment())
        fragmentTransaction.commit()
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout, PagingFragment())
                    fragmentTransaction.commit()
                    true
                }

                R.id.saved -> {
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout, DatabaseResult())
                    fragmentTransaction.commit()
                    true
                }
                else -> false
            }
        }


        //registering the receiver to a aeroplane broadacast
        receiver = AeroplaneModeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}