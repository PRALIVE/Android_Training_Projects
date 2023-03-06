package com.example.androidservices

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.graphics.drawable.IconCompat

class ForgroundService : Service() {

   companion object {
         lateinit var musicplayer: MediaPlayer
    }
    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        musicplayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        musicplayer.isLooping = true
        musicplayer.start()


        val notification : Notification = createNotification()
        startForeground(1,notification)
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun createNotification() : Notification {

        //pendingIntent
        val notifyIntent = Intent(this, MainActivity::class.java)
        val notifyPendingIntent = PendingIntent.getActivity(
            applicationContext, 0, notifyIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "notify","my_service_notification",NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        val notificationbuilder = NotificationCompat.Builder(this,"notify")
            .setContentTitle("Forground Service")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Running.....")
            .setContentIntent(notifyPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        return notificationbuilder.build()
    }
}