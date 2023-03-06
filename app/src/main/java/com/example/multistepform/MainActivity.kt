package com.example.multistepform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.multistepform.adapter.ViewPagerAdapter
import com.example.multistepform.database.UserDatabase
import com.example.multistepform.datamodels.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var user  = User()
    lateinit var viewPager : ViewPager2
    lateinit var previous : Button
    lateinit var next : Button
    lateinit var submit : Button
    lateinit var refresh : Button
    lateinit var swiperefresh : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //first make a instance of database
        val room = Room.databaseBuilder(
            this,
            UserDatabase::class.java,"SavedInfo"
        ).fallbackToDestructiveMigration().build()
        val roomdao = room.userDao()

        CoroutineScope(Dispatchers.IO).launch {
            if(roomdao.getUserById(0)!=null){
                val user1 = roomdao.getUserById(0)!!
                user.firstname = user1.firstname
                user.secondname = user1.secondname
                user.email = user1.email
                user.phone = user1.phone
                user.address1 = user1.address1
                user.address2 = user1.address1
                user.address3 = user1.address3
            }else{
                roomdao.insertArticles(user)
            }

        }

        viewPager = findViewById<ViewPager2>(R.id.viewpager)
        previous = findViewById<Button>(R.id.previous)
        next = findViewById<Button>(R.id.next)
        submit = findViewById<Button>(R.id.submit)
        refresh = findViewById<Button>(R.id.refresh)
        swiperefresh = findViewById(R.id.swipe_refresh_layout)

        swiperefresh.setOnRefreshListener {
            CoroutineScope(Dispatchers.IO).launch{
                roomdao.updateUser(user)
                swiperefresh.isRefreshing = false
            }
        }


        checkbuttons()
        val myAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        myAdapter.addFragment(firstFragment(user,roomdao))
        myAdapter.addFragment(secondFragment(user,roomdao))
        myAdapter.addFragment(thirdFragment(user,roomdao))

        viewPager.adapter = myAdapter

        viewPager.isUserInputEnabled = false;

        next.setOnClickListener(){
           val  currentindex : Int = viewPager.currentItem
            val fragment : MyFragment = myAdapter.getfragment(currentindex)
            Log.d("savedinformation",fragment.saveinfo().toString())
            if(fragment.saveinfo()){
                viewPager.setCurrentItem(viewPager.currentItem + 1,true)
                checkbuttons()
            }
        }

        previous.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.currentItem - 1,true)
            checkbuttons()
        }

        submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information Filled").setMessage("Name: ${user.firstname} ${user.secondname}\nPhone: ${user.phone}\nEmail: ${user.email}\nAddress: ${user.address1}, ${user.address2}, ${user.address3}")
                .setPositiveButton("OK"){ _, id ->
                    //save it to database
                    val fragment1 : MyFragment = myAdapter.getfragment(0)
                    val fragment2 : MyFragment = myAdapter.getfragment(1)
                    val fragment3 : MyFragment = myAdapter.getfragment(2)
                    fragment1.updateallfiels()
                    fragment2.updateallfiels()
                    fragment3.updateallfiels()
                    CoroutineScope(Dispatchers.IO).launch{
                        roomdao.delete(user)
                    }
                }
            val dialog = builder.create()
            dialog.show()
        }

        refresh.setOnClickListener {
            recreate()
        }
    }

    fun checkbuttons(){
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