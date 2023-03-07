package com.example.navigationdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //start page when activity starts
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,HomeFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        //disable swiping
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)


        navView = findViewById(R.id.navView)
        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout,UserFragment())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout,PeopleFragment())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout,SettingFragment())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    true
                }
                R.id.item4 -> {
                    Toast.makeText(this, "Movies", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout,MovieFragment())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    true
                }
                R.id.item5 -> {
                    Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.framelayout,HomeFragment())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}