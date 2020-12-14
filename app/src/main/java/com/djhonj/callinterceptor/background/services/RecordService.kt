package com.djhonj.callinterceptor.background.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class RecordService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, "servicio iniciado", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "servicio destruido", Toast.LENGTH_SHORT).show();
        return super.onDestroy()
    }
}