package com.djhonj.callinterceptor.background.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.djhonj.callinterceptor.background.services.RecordService

class InterceptorBroadcast : BroadcastReceiver() {
    //private val state_call: List<String> by lazy { listOf<String>("ringing", "offhook", "idle") }

    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.extras?.getString("state")
        //val changeCall = intent.getStringExtra(intent.)

        extras?.let {
            //val state: String? = it?.getString("state")

            when(it.toLowerCase()){
                "ringing" -> Toast.makeText(context, "Telefono sonando", Toast.LENGTH_SHORT).show()
                "offhook" -> {
                    Toast.makeText(context, "Hablando con alguien (entrante o saliente)", Toast.LENGTH_SHORT).show()
                }
                "idle" -> {
                    Toast.makeText(context, "Llamada finalizada (entrante o saliente)", Toast.LENGTH_SHORT).show()
                }
                else -> Toast.makeText(context, "Problemas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
