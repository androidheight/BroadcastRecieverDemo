package com.androidheight.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyPhoneStateListener extends BroadcastReceiver{

    Context mContext;





   @Override
    public void onReceive(Context mContext, Intent intent)    {
        try {

            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);



            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))            {

                String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);  // 5
               String  msg = "Incoming number is " + incomingNumber;
                Toast.makeText(mContext, " your Phone Is Ringing\n"+msg, Toast.LENGTH_LONG).show();
            }

            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            {
                Toast.makeText(mContext, "Call Recieved", Toast.LENGTH_LONG).show();
                // Your Code
            }

            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE))
            {

                Toast.makeText(mContext, "Phone Is Disconnected or Idle", Toast.LENGTH_LONG).show();
                // Your Code

            }
        }
        catch(Exception e)
        {
            //your custom message
        }

    }

}