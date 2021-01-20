package com.example.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SenderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        //Toast.makeText(context, "SenderReceiver triggered", Toast.LENGTH_SHORT).show()

        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++
        stringExtra += "-> SenderReceiver"

        val toastText =
            "\"SenderReceiver \n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "SenderReceiver"
        resultExtras.putString("stringExtra", stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}