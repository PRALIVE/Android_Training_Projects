package com.example.viewpager2app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FourthFragment : Fragment() {

    val TAG="Fourth"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate invoked on Fourthfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView invoked on Fourthfragment")
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onViewCreate invoked on Fourthfragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored invoked on Fourthfragment")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart invoked on Fourthfragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume invoked on Fourthfragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause invoked on Fourthfragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop invoked on Fourthfragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState invoked on Fourthfragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView invoked on Fourthfragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy invoked on Fourthfragment")
    }

}