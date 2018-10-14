package com.extremetech.cameraapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("numeros", "onRecive");

        takePhoto(context);

        /*Intent intent2 = new Intent();
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent2.setClass(context, CameraActivity.class);
        context.startActivity(intent2);
        Log.d("numeros","onRecive2");*/
    }

    public void takePhoto(Context context) {

        Intent myIntent = new Intent(context, CameraActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);
        Log.d("numeros","onRecive3");

    }
}
