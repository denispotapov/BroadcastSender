package com.example.broadcastsender

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            //intent.setClass(this, ExampleBroadcastReceiver2::class.java)

            /*val componentName = ComponentName(
                "com.example.broadcastreceiverexample",
                "com.example.broadcastreceiverexample.ExampleBroadcastReceiver")
            intent.component = componentName*/

            /*intent.setClassName("com.example.broadcastreceiverexample",
                "com.example.broadcastreceiverexample.ExampleBroadcastReceiver")*/

            //intent.setPackage("com.example.broadcastreceiverexample")

            val packageManager = packageManager
            val infos = packageManager.queryBroadcastReceivers(intent, 0)

            for (info in infos) {
                val componentName =
                    ComponentName(info.activityInfo.packageName, info.activityInfo.name)
                intent.component = componentName
                sendBroadcast(intent)
            }

            //sendBroadcast(intent)
        }
    }
}