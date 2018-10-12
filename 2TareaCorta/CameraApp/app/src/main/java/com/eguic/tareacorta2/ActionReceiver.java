package com.eguic.tareacorta2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;

public class ActionReceiver extends BroadcastReceiver {

    private Activity mActivity;


    public ActionReceiver(Activity activity){
        this.mActivity = activity;
    }

    public ActionReceiver(){
    }

    public void photo(Context context, int number) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            mActivity.startActivityForResult(takePictureIntent, number);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("numero","dvgbh");
        String  number = intent.getExtras().getString("number");
        Log.d("numero",number);
        photo(context, Integer.valueOf(number));
    }
}
