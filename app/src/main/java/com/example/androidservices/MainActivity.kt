package com.example.androidservices

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var startbtn : Button
    lateinit var stopbtn : Button
    lateinit var next : Button
    var serviceIntent : Intent? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        startbtn = findViewById(R.id.start)
        stopbtn = findViewById(R.id.stop)
        next = findViewById(R.id.nextscreen)

        startbtn.setOnClickListener {
            if(serviceIntent==null) {
                serviceIntent = Intent(this, ForgroundService::class.java)
                startForegroundService(serviceIntent)
            }
        }

        stopbtn.setOnClickListener {
            stopService(serviceIntent)
            ForgroundService.musicplayer.stop()
        }

        next.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity1","I am destroyed now")
    }

    private fun stopForegroundService() {
        // stop the foreground service and then stop the service
        val intent = Intent(this, ForgroundService::class.java)
        stopService(intent)
    }






}