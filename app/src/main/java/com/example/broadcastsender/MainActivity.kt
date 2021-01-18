package com.example.broadcastsender

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastsender.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val senderReceiver = SenderReceiver()
    private lateinit var localBroadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        binding.btnSendBroadcast.setOnClickListener {
            val intent = Intent("com.example.broadcastreceiverexample.ACTION_EXAMPLE");
            localBroadcastManager.sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.example.broadcastreceiverexample.ACTION_EXAMPLE")
        localBroadcastManager.registerReceiver(senderReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        localBroadcastManager.unregisterReceiver(senderReceiver)
    }
}