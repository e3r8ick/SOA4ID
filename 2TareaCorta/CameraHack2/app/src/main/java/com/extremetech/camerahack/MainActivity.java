package com.extremetech.camerahack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takePhoto(View view){
        Log.d("numeros","entro");
        Intent takePictureIntent = new Intent("com.extremetech.cameraapp.takePhoto");
        Log.d("numeros",takePictureIntent.toString());
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            Log.d("numeros","entroasdasd");
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        Log.d("numeros","salio");


        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.extremetech.cameraapp.takePhoto");
        startActivity(LaunchIntent);
    }
}
