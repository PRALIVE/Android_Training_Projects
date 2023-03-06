package com.example.androidservices

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    private lateinit var musicplayer : MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //return super.onStartCommand(intent, flags, startId)
        musicplayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        musicplayer.isLooping = true
        musicplayer.start()
        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        musicplayer.stop()
    }
}