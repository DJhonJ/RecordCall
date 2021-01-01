package com.djhonj.callinterceptor.background.services

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.djhonj.callinterceptor.App
import com.djhonj.callinterceptor.background.broadcast.InterceptorBroadcast
import com.djhonj.callintenceptor.R

class RecordService: Service() {
    val notificationId: Int = 1

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(applicationContext, App.CHANNEL_ID).apply {

            val pendingIntent = PendingIntent
                .getService(applicationContext, 0, Intent(applicationContext,
                    RecordService::class.java).apply { putExtra("cancel_service", "1") },0)

            setSmallIcon(R.drawable.ic_foreground_phone)
            setContentTitle(getString(R.string.notification_title))
            setContentText(getString(R.string.notification_text))
            addAction(R.mipmap.ic_launcher_round, getString(R.string.notification_accion_cancel), pendingIntent)
        }.run { build() }

        startForeground(notificationId, notification)

        val cancel= intent?.getStringExtra("cancel_service")
        if (cancel != null) stopSelf()

        return START_STICKY
    }

    override fun onDestroy() {
        //unregisterReceiver(InterceptorBroadcast())
        return super.onDestroy()
    }
}