package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate invoked on activity1")
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            //change the activity

            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as BlankFirst
            fragment.textView.text = "Changed state"
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause invoked on activity1")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart invoked on activity1")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume invoked on activity1")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop invoked on activity1")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart invoked on activity1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy invoked on activity1")
    }
    }