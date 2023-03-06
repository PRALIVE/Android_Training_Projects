package com.example.broadcastreceiver.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class secondreceiver() : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val p : String? = p1?.getStringExtra("message")
        //Toast.makeText(p0,p.toString(), Toast.LENGTH_SHORT).show()
    }
}