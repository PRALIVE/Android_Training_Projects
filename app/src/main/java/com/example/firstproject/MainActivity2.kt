package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    val TAG = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate invoked on activity2")
        setContentView(R.layout.activity_main2)
        val btn: Button = findViewById(R.id.button1)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
        val btn2: Button = findViewById(R.id.buttona3)
        btn2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }

        val btn3: Button = findViewById(R.id.buttona4)
        btn3.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause invoked on activity2")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart invoked on activity2")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume invoked on activity2")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop invoked on activity2")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart invoked on activity2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy invoked on activity2")
    }
}