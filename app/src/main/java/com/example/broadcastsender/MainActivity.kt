package com.example.broadcastsender

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastsender.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendBroadcast.setOnClickListener {
            val intent = Intent("com.example.broadcastreceiverexample.ACTION_EXAMPLE")
            intent.setPackage("com.example.broadcastreceiverexample")

            val extras = Bundle()
            extras.putString("stringExtra", "Start")

            sendOrderedBroadcast(intent, null, SenderReceiver(),
                null, 0, "Start", extras)
        }
    }
}