package com.example.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "ExampleBroadcastReceiver2 triggered", Toast.LENGTH_SHORT).show()
    }
}