package com.example.launchmodesproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("checkinglaunchmodes","onCreate is invoked on Activity2")
        setContentView(R.layout.activity_main2)
    }

    fun launchnextactivity(view: View) {
        startActivity(Intent(this,MainActivity3::class.java))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("checkinglaunchmodes","onNewIntent is invoked on Activity2")
    }

    fun launchsameactivity(view: View) {
        startActivity(Intent(this,MainActivity2::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkinglaunchmodes","onDestroy is invoked on Activity2")
    }
}