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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        Log.d("numeros","takephoto");
        /*Intent intent = new Intent(MainActivity.this,CameraActivity.class);
        startActivity(intent);*/


        Intent inntent = new Intent(MainActivity.this, ActionReceiver.class);
        inntent.putExtra("number", REQUEST_IMAGE_CAPTURE);
        getApplicationContext().sendBroadcast(inntent);
        Log.d("numeros","takephotosaldia");
    }
}
