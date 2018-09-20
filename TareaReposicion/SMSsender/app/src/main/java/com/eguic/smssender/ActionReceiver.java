package com.eguic.smssender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

public class ActionReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        String  number = intent.getExtras().getString("number");
        String  message = intent.getExtras().getString("message");
        send(message,number);
    }

    public void send(String message, String number){
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number,null,message,null,null);
        Log.d("envio de mensaje",number);
        Log.d("envio de mensaje",message);
    }
}
