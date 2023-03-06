package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import timber.log.Timber.Forest.plant


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(BuildConfig.DEBUG){
            plant(Timber.DebugTree())
        }
    }
}