package com.example.viewpager2app

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        val btn = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        viewPager.isUserInputEnabled = false;


//        val images = listOf(
//            R.drawable.img1,
//            R.drawable.img2,
//            R.drawable.img3,
//            R.drawable.img4,
//            R.drawable.img5,
//            R.drawable.img6,
//            R.drawable.img7
//        )
        btn.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.currentItem + 1,true)
        }

        btn2.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.currentItem - 1,true)
        }

        //val adapter = ViewPagerAdapter(images)
        val myAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        myAdapter.addFragment(FirstFragment())
        myAdapter.addFragment(SecondFragment())
        myAdapter.addFragment(ThirdFragment())
        myAdapter.addFragment(FourthFragment())

        viewPager.adapter = myAdapter
    }
}