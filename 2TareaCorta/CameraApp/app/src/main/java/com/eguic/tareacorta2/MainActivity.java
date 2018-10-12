package com.eguic.tareacorta2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    static final String REQUEST_IMAGE_CAPTURE = "1";
    private ActionReceiver mActionReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionReceiver = new ActionReceiver(this);
    }

    public void takePhoto(View view) {
        Log.d("numero","ffsrfr");
        Intent intent = new Intent(MainActivity.this,ActionReceiver.class);
        intent.putExtra("number",REQUEST_IMAGE_CAPTURE);
        Log.d("numero","56156r");
        getApplicationContext().sendBroadcast(intent);
        //mActionReceiver.photo(this, this);
    }
}
