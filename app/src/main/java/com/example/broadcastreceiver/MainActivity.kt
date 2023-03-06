package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastreceiver.receivers.Broadcastreceiverdata
import com.example.broadcastreceiver.receivers.MyExplicitReceiver
import com.example.broadcastreceiver.receivers.secondreceiver

class MainActivity : AppCompatActivity() {

    lateinit var button : Button
    lateinit var text : TextView
    lateinit var stext : TextView
    lateinit var nextbtn : Button
    val ACTION_MY_CUSTOM_ACTION = "com.example.broadcastreceiver.MY_ACTION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.broadcastbutton)
        text = findViewById(R.id.textview)
        stext = findViewById(R.id.secondreceiver)
        nextbtn=findViewById(R.id.nextbtn)

        //implicit working in every activity
        val receiver3 = AeroplaneReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED,).also {
            registerReceiver(receiver3,it)
        }

        val receiver = Broadcastreceiverdata()
        val receiver2 = secondreceiver()



        //making explicit broadcast receiver
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("explicit")
//        val myBroadcastReceiver = MyExplicitReceiver()
//        registerReceiver(myBroadcastReceiver, intentFilter)

//        val intent = Intent(ACTION_MY_CUSTOM_ACTION)
//        intent.putExtra("message", "I am broadcasting statically")
//        sendBroadcast(intent)


        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter("sending_data"))
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver2, IntentFilter("sending_data"))

        button.setOnClickListener {
            val intent : Intent = Intent("sending_data")
            intent.putExtra("message","Message Broadcasted")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

//            val intent1 = Intent(this, MyExplicitReceiver::class.java)
//            intent1.action = "explicit"
//            intent1.putExtra("message","explicit receiver is broadcasted")
//            sendBroadcast(intent1)

//            val intent = Intent(ACTION_MY_CUSTOM_ACTION)
//            intent.putExtra("message", "I am broadcasting statically")
//            sendBroadcast(intent)
        }

        nextbtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
}