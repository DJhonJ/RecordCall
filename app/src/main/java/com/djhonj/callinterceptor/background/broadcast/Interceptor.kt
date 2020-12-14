package com.djhonj.callinterceptor.background.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.djhonj.callinterceptor.background.services.RecordService

class Interceptor : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val extras:Bundle? = intent.extras
        //val changeCall = intent.getStringExtra(intent.)

        if (extras != null) {
            var state: String? = extras?.getString("state")

            when(state?.toLowerCase()){
                "ringing" -> Toast.makeText(context, "Telefono sonando", Toast.LENGTH_SHORT).show()
                "offhook" -> {
                    Toast.makeText(context, "Hablando con alguien (entrante o saliente)", Toast.LENGTH_SHORT).show()
                    startRecordService(context)
                }
                "idle" -> {
                    Toast.makeText(context, "Llamada finalizada (entrante o saliente)", Toast.LENGTH_SHORT).show()
                    stopRecordService(context)
                }
                else -> Toast.makeText(context, "Problemas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startRecordService (context: Context) {
        context.startService(Intent(context, RecordService::class.java))
    }

    private fun stopRecordService(context: Context) {
        context.stopService(Intent(context, RecordService::class.java))
    }
}
