package com.example.servicetesttool

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.*
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.servicetesttool.Constants.Companion.foregroundServiceNotificationTitle

private const val TAG = "CounterService"

class CounterService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra(Constants.inputExtra)
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
// 1

        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")
            } else {
                // If earlier version channel ID is not used
                // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                ""
            }
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(foregroundServiceNotificationTitle)
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_baseline_access_alarms_24)
            .setContentIntent(pendingIntent)
            .build()
        val timer = object : CountDownTimer(100000, 1000) {
            var a = 0
            override fun onTick(millisUntilFinished: Long) {
                Log.d(TAG, "onTick: $a")
                a++
                // do something
            }

            override fun onFinish() {
                Log.d(TAG, "done ")
                stopSelf()
                // do something
            }
        }
        timer.start()



        startForeground(1, notification)
// 2
        return START_NOT_STICKY
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String {
        val chan = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }
}