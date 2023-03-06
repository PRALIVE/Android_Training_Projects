package com.example.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(fragmentActivity : FragmentActivity)  : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       // return
      return  if(position==0){

          SignIn()
        }else{
          SignUp()
        }

//        return when (position) {
//            0 -> SignUp()
//            1 -> SignIn()
//            else-
//        }
    }

}