package com.example.broadcastreceiver.receivers

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class Broadcastreceiverdata() : android.content.BroadcastReceiver() {

    val ACTION_MY_CUSTOM_ACTION = "com.example.broadcastreceiver.MY_ACTION"
    override fun onReceive(p0: Context?, p1: Intent?) {

        val action = p1?.action
        if (ACTION_MY_CUSTOM_ACTION == action) {
            val message = p1?.getStringExtra("message")
            Toast.makeText(p0,message.toString(), Toast.LENGTH_SHORT).show()
            // handle the broadcast message here
        }
    }
}