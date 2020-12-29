package com.djhonj.callinterceptor

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App: Application() {
    companion object {
        val CHANNEL_ID = "record_call"
    }

    override fun onCreate(){
        super.onCreate()
        createNotificationChannel()
    }

    //canal para las notificaciones en versiones android >= 8
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, "Record_NotificationChannel", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}