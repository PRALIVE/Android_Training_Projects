package com.example.launchmodesproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("checkinglaunchmodes","onCreate is invoked on Activity4")
        setContentView(R.layout.activity_main4)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("checkinglaunchmodes","onNewIntent is invoked on Activity4")
    }

    fun launchsingletask(view: View) {
        startActivity(Intent(this,MainActivity3::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkinglaunchmodes","onDestroy is invoked on Activity4")
    }
}