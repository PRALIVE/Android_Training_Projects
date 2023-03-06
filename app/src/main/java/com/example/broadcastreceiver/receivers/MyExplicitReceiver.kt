package com.example.broadcastreceiver.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyExplicitReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val p : String? = p1?.getStringExtra("message")
        Log.d("explicitreceiver", p.toString())
       // Toast.makeText(p0,"Explicit is broadcasted", Toast.LENGTH_LONG).show()
    }
}