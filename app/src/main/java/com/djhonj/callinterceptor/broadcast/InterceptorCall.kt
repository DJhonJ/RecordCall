package com.djhonj.callinterceptor.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Toast

class InterceptorCall : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val extras:Bundle? = intent.extras
        //val changeCall = intent.getStringExtra(intent.)

        if (extras != null) {
            var state: String? = extras?.getString("state")

            when(state?.toLowerCase()){
                "ringing" -> Toast.makeText(context, "Telefono sonando", Toast.LENGTH_SHORT).show()
                "offhook" -> Toast.makeText(context, "Hablando con alguien (entrante o saliente)", Toast.LENGTH_SHORT).show()
                "idle" -> Toast.makeText(context, "Llamada finalizada (entrante o saliente)", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(context, "Problemas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
