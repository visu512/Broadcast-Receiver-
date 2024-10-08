package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeReciever: BroadcastReceiver() {
  
    override fun onReceive(context: Context?, intent: Intent?) {
        val isOn = intent?.getBooleanExtra("state",false)
        if(isOn == true ){
            Toast.makeText(context, "Airplane Mode ON ", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Airplane Mode OFF ", Toast.LENGTH_SHORT).show()

        }
    }
}