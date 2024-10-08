
package com.example.broadcastreciever

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirPlaneModeReciever
    lateinit var internetReceiver:InternetReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Airplane mode receiver
        receiver = AirPlaneModeReciever()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        // Internet connectivity receiver
        internetReceiver = InternetReceiver()
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(internetReceiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        unregisterReceiver(internetReceiver)
    }
}


