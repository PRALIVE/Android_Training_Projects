package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity3 : AppCompatActivity() {
    val TAG = "MainActivity3"
    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate invoked on activity3")
        setContentView(R.layout.activity_main3)
    }

    fun onClickFirst(view: View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, FirstFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun onClickSecond(view: View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, SecondFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause invoked on activity3")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart invoked on activity3")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume invoked on activity3")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop invoked on activity3")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart invoked on activity3")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy invoked on activity3")
    }
}