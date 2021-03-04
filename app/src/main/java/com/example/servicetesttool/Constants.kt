package com.example.servicetesttool

import android.net.Uri

class Constants {

    companion object {

        // Intent Constants
        const val inputExtra = "inputExtra"

        // Notification Constants
        const val channelID = "myServiceChannel"
        const val foregroundServiceNotificationTitle = "My Foreground Services"
        const val foregroundIntentServiceNotificationTitle = "My Foreground Intent Service"
        const val notificationChannelName = "My Service Channel"
        val AUTHORITY = "com.example.servicetesttool.DataProvider"
        val URL = Uri.parse("content://" + AUTHORITY + "/t1")
        val CONTENT_TYPE = "contentproviderlab.t12"
        val ID = "_ID"
        val TEXT = "MESSAGE"
        val TEXT_DATA = "Hello Content Providers!"

        // Job scheduler Constants
        const val jobId = 123
    }

}