package com.example.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastsender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendBroadcast.setOnClickListener {
            val intent = Intent("com.example.broadcastreceiverexample.EXAMPLE_ACTION")
            intent.putExtra("com.example.broadcastreceiverexample.EXAMPLE_ACTION", "Broadscast received")
            sendBroadcast(intent)
        }
    }

    private val broadcastReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val receivedText = intent?.getStringExtra("com.example.broadcastreceiverexample.EXAMPLE_ACTION")
            binding.textView.text = receivedText
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.example.broadcastreceiverexample.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}