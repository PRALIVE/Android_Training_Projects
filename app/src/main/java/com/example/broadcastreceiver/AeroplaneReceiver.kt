package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AeroplaneReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        Log.d("receivedmessage","message received")

        val isAeroplaneModeEnabled = p1?.getBooleanExtra("state", false) ?: return

        if(isAeroplaneModeEnabled){
            Toast.makeText(p0,"Aeroplane Mode Enables", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(p0,"Aeroplane Mode Disabled", Toast.LENGTH_SHORT).show()
        }
    }

}