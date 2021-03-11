package com.example.servicetesttool

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.work.impl.utils.ForceStopRunnable


private const val TAG = "MyBroadcastReceiver"

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val myIntent = Intent(Intent.ACTION_MAIN)
        myIntent.component =
            ComponentName("com.example.servicetesttool", "com.example.servicetesttool.MainActivity")

        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(context, myIntent, null)


        StringBuilder().apply {
            append("Action: ${myIntent.action}\n")
            append("URI: ${myIntent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, "receive broadcast success", Toast.LENGTH_LONG).show()
            }
        }
    }
}