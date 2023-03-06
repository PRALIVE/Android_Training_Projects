package com.example.viewpager2app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment() {

    val TAG = "First"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate invoked on Firstfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_first, container, false)
        Log.d(TAG,"onCreateView invoked on Firstfragment")
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onViewCreate invoked on Firstfragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored invoked on Firstfragment")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart invoked on Firstfragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume invoked on Firstfragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause invoked on Firstfragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop invoked on Firstfragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState invoked on Firstfragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView invoked on Firstfragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy invoked on Firstfragment")
    }
}