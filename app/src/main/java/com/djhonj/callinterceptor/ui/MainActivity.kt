package com.djhonj.callinterceptor.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.djhonj.callintenceptor.R
import com.djhonj.callinterceptor.background.services.RecordService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        startService(Intent(view.context, RecordService::class.java))
    }

    fun stop(view: View) {
        val intent = Intent(view.context, RecordService::class.java).apply {
            putExtra("cancel_service", "1")
        }

        stopService(intent)
    }
}