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

class ThirdFragment : Fragment() {
    val TAG = "ThirdFragment"
    private lateinit var btn1:Button
    private lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d(TAG,"onCreate invoked on Thirdfragment")
        Timber.d("onCreate invoked on Thirdfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        Log.d(TAG,"onCreateView invoked on Thirdfragment")
        Timber.d("onCreateView invoked on Thirdfragment")
        val view:View = inflater.inflate(R.layout.fragment_third, container, false)
        btn1 = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)

        btn1.setOnClickListener(){
            findNavController().navigate(R.id.from_third_to_first)
        }

//        btn2.setOnClickListener(){
//            findNavController().navigate(R.id.from_third_to_second)
//        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d(TAG,"onViewCreate invoked on Thirdfragment")
        Timber.d("onViewCreate invoked on Thirdfragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
//        Log.d(TAG,"onViewStateRestored invoked on Thirdfragment")
        Timber.d("onViewStateRestored invoked on Thirdfragment")
    }

    override fun onStart() {
        super.onStart()
//        Log.d(TAG,"onStart invoked on Thirdfragment")
        Timber.d("onStart invoked on Thirdfragment")
    }

    override fun onResume() {
        super.onResume()
//        Log.d(TAG,"onResume invoked on Thirdfragment")
        Timber.d("onResume invoked on Thirdfragment")
    }

    override fun onPause() {
        super.onPause()
//        Log.d(TAG,"onPause invoked on Thirdfragment")
        Timber.d("onPause invoked on Thirdfragment")
    }

    override fun onStop() {
        super.onStop()
//        Log.d(TAG,"onStop invoked on Thirdfragment")
        Timber.d("onStop invoked on Thirdfragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        Log.d(TAG,"onSaveInstanceState invoked on Thirdfragment")
        Timber.d("onSaveInstanceState invoked on Thirdfragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        Log.d(TAG,"onDestroyView invoked on Thirdfragment")
        Timber.d("onDestroyView invoked on Thirdfragment")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d(TAG,"onDestroy invoked on Thirdfragment")
        Timber.d("onDestroy invoked on Thirdfragment")
    }
}