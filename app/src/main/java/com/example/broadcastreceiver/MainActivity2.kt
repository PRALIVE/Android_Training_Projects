package com.example.broadcastreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastreceiver.receivers.Broadcastreceiverdata
import com.example.broadcastreceiver.receivers.secondreceiver

class MainActivity2 : AppCompatActivity() {

    lateinit var button : Button
    lateinit var backbtn : Button
    lateinit var state1 : TextView
    lateinit var state2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button = findViewById(R.id.broadcast)
        backbtn = findViewById(R.id.back)
        state1 = findViewById(R.id.state1)
        state2 = findViewById(R.id.state2)


        button.setOnClickListener {
                val intent : Intent = Intent("sending_data")
                intent.putExtra("message","Message Broadcasted 2")
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }

        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }

    }
}