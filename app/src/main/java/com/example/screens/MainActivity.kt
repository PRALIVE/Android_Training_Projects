package com.example.screens

import android.graphics.Typeface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpager = findViewById<ViewPager2>(R.id.viewpager)
        val tablayout = findViewById<TabLayout>(R.id.tabLayout)

        viewpager.adapter = Adapter(this)

        TabLayoutMediator(tablayout,viewpager, TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
            when(position){
                0 -> {tab.text = "SIGN IN"}
                else ->  {tab.text = "SIGN UP"}
            }
        }).attach()
    }
}