package com.example.androidservices

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {

    private val binder = MyBinder()

    inner class MyBinder : Binder() {
        fun getService(): MyBoundService {
            return this@MyBoundService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun startPrinting() {
        Thread(Runnable {
            while (true) {
                Log.d("MyBoundService", "Printing from service")
                Thread.sleep(1000)
            }
        }).start()
    }
}
