package com.example.launchmodesproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar

class MyCustomDialog : DialogFragment() {

    lateinit var yesButton : Button
    lateinit var noButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View =  inflater.inflate(R.layout.custom_layout,container,false)

        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner_shape)
        yesButton = view.findViewById(R.id.yesButton)
        noButton = view.findViewById(R.id.noButton)

        yesButton.setOnClickListener {
            Toast.makeText(context,"Yes",Toast.LENGTH_SHORT).show()
            dismiss()
        }

        noButton.setOnClickListener {
            Toast.makeText(context,"No",Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}