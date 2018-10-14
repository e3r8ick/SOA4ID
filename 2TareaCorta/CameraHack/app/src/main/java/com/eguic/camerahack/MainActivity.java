package com.eguic.camerahack;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takePhoto(View view){
        Log.d("numeros","entro");
        Intent takePictureIntent = new Intent("com.eguic.tareacorta2.takePhoto");
        Log.d("numeros",takePictureIntent.toString());
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            Log.d("numeros","entroasdasd");
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        Log.d("numeros","salio");


        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.eguic.tareacorta2.takePhoto");
        startActivity(LaunchIntent);
    }
}
