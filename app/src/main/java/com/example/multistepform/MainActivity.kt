package com.example.multistepform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.multistepform.adapter.ViewPagerAdapter
import com.example.multistepform.database.UserDatabase
import com.example.multistepform.databinding.ActivityMainBinding
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var user  = User()
    lateinit var viewPager : ViewPager2
    lateinit var previous : Button
    lateinit var next : Button
    lateinit var submit : Button
    lateinit var refresh : Button
    lateinit var swipeRefresh : SwipeRefreshLayout
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewPager = binding.viewpager
        previous = binding.previous
        next = binding.next
        submit = binding.submit
        swipeRefresh = binding.swipeRefreshLayout
        refresh = binding.refresh
        //setContentView(R.layout.activity_main)

        //first make a instance of database
        val room = Room.databaseBuilder(
            this,
            UserDatabase::class.java,"SavedInfo"
        ).fallbackToDestructiveMigration().build()
        val roomDao = room.userDao()

        CoroutineScope(Dispatchers.IO).launch {
            if(roomDao.getUserById(0)!=null){
                val user1 = roomDao.getUserById(0)!!
                user.firstName = user1.firstName
                user.secondName = user1.secondName
                user.email = user1.email
                user.phone = user1.phone
                user.address1 = user1.address1
                user.address2 = user1.address1
                user.address3 = user1.address3
            }else{
                roomDao.insertArticles(user)
            }

        }

//        viewPager = findViewById<ViewPager2>(R.id.viewpager)
//        previous = findViewById<Button>(R.id.previous)
//        next = findViewById<Button>(R.id.next)
//        submit = findViewById<Button>(R.id.submit)
//        refresh = findViewById<Button>(R.id.refresh)
//        swipeRefresh = findViewById(R.id.swipe_refresh_layout)

        swipeRefresh.setOnRefreshListener {
            CoroutineScope(Dispatchers.IO).launch{
                roomDao.updateUser(user)
                swipeRefresh.isRefreshing = false
            }
        }


        checkButtons()
        val myAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        myAdapter.addFragment(FirstFragment(user,roomDao))
        myAdapter.addFragment(SecondFragment(user,roomDao))
        myAdapter.addFragment(ThirdFragment(user,roomDao))

        viewPager.adapter = myAdapter

        viewPager.isUserInputEnabled = false;

        next.setOnClickListener(){
           val  currentindex : Int = viewPager.currentItem
            val currentFragment = myAdapter.getFragment(currentindex)
            Log.d("savedinformation",(currentFragment as ValidateInfo).isValid().toString())
            if((currentFragment as ValidateInfo).isValid()){
                viewPager

                    .setCurrentItem(viewPager.currentItem + 1,true)
                checkButtons()
            }
        }

        previous.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.currentItem - 1,true)
            checkButtons()
        }

        submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information Filled").setMessage("Name: ${user.firstName} ${user.secondName}\nPhone: ${user.phone}\nEmail: ${user.email}\nAddress: ${user.address1}, ${user.address2}, ${user.address3}")
                .setPositiveButton("OK"){ _, id ->
                    //save it to database
                    val fragment1 = myAdapter.getFragment(0)
                    val fragment2 = myAdapter.getFragment(1)
                    val fragment3 = myAdapter.getFragment(2)
                    (fragment1 as FirstFragment).updateAllFields()
                    (fragment2 as SecondFragment).updateAllFields()
                    (fragment3 as ThirdFragment).updateAllFields()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomDao.delete(user)
                    }
                }
            val dialog = builder.create()
            dialog.show()
        }

        refresh.setOnClickListener {

        }
    }

    fun checkButtons(){
        if(viewPager.currentItem == 0){
            refresh.setVisibility(View.VISIBLE)
            previous.setVisibility(View.GONE)
            next.setVisibility(View.VISIBLE)
            submit.setVisibility(View.GONE)
        }else if(viewPager.currentItem == 1){
            refresh.setVisibility(View.GONE)
            previous.setVisibility(View.VISIBLE)
            next.setVisibility(View.VISIBLE)
            submit.setVisibility(View.GONE)
        }else if(viewPager.currentItem == 2){
            refresh.setVisibility(View.GONE)
            next.setVisibility(View.GONE)
            previous.setVisibility(View.VISIBLE)
            submit.setVisibility(View.VISIBLE)
        }
    }
}