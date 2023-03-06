package com.example.firstproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val fragment1 = supportFragmentManager.findFragmentById(R.id.fragment1) as ButtonFragment
        val fragment2 = supportFragmentManager.findFragmentById(R.id.fragment2) as ColorFragment

        fragment1.btn1.setOnClickListener(){
            fragment2.textView.text = "Red"
            fragment2.frame.setBackgroundColor(Color.parseColor("#ED1414"))
        }

        fragment1.btn2.setOnClickListener(){
            fragment2.textView.text = "Blue"
            fragment2.frame.setBackgroundColor(Color.parseColor("#142AED"))
        }
    }
}