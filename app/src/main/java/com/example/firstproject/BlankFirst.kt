package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.util.Log
import android.widget.TextView


class BlankFirst : Fragment(){
    val TAG = "BlankFirst"
    public lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate invoked on Blankfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView invoked on Blankfragment")
        val view: View = inflater!!.inflate(R.layout.fragment_first, container, false)
        textView = view.findViewById(R.id.text)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onViewCreate invoked on Blankfragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored invoked on Blankfragment")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart invoked on Blankfragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume invoked on Blankfragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause invoked on Blankfragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop invoked on Blankfragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState invoked on Blankfragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView invoked on Blankfragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy invoked on Blankfragment")
    }

}