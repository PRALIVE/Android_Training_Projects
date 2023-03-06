package com.example.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import timber.log.Timber

class SecondFragment : Fragment() {

    val TAG = "SecondFragment"
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d(TAG,"onCreate invoked on Secondfragment")
        Timber.d("onCreate invoked on Secondfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        Log.d(TAG,"onCreateView invoked on Secondfragment")
        Timber.d("onCreateView invoked on Secondfragment")
        val view:View = inflater.inflate(R.layout.fragment_second, container, false)
        btn = view.findViewById(R.id.btn1)
        btn.setOnClickListener(){
            findNavController().navigate(R.id.from_second_to_third)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d(TAG,"onViewCreate invoked on Secondfragment")
        Timber.d("onViewCreated invoked on Secondfragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
//        Log.d(TAG,"onViewStateRestored invoked on Secondfragment")
        Timber.d("onViewStateRestored invoked on Secondfragment")
    }

    override fun onStart() {
        super.onStart()
//        Log.d(TAG,"onStart invoked on Secondfragment")
        Timber.d("onStart invoked on Secondfragment")
    }


    override fun onResume() {
        super.onResume()
//        Log.d(TAG,"onResume invoked on Secondfragment")
        Timber.d("onResume invoked on Secondfragment")
    }

    override fun onPause() {
        super.onPause()
//        Log.d(TAG,"onPause invoked on Secondfragment")
        Timber.d("onPause invoked on Secondfragment")
    }

    override fun onStop() {
        super.onStop()
//        Log.d(TAG,"onStop invoked on Secondfragment")
        Timber.d("onStop invoked on Secondfragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        Log.d(TAG,"onSaveInstanceState invoked on Secondfragment")
        Timber.d("onSaveInstanceState invoked on Secondfragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        Log.d(TAG,"onDestroyView invoked on Secondfragment")
        Timber.d("onDestroyView invoked on Secondfragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Log.d(TAG,"onDestroy invoked on Secondfragment")
        Timber.d("onDestroy invoked on Secondfragment")
    }
}