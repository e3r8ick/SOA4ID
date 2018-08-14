package com.example.eguic.myfirstapp;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public String mvalor;
    public SharedPreferences mprefs;
    public String tec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        //print de prueba
        Log.d(" CREATION","onCreate");
        setContentView(R.layout.activity_main);
        mvalor = "Hola";
        mprefs = getSharedPreferences("SOA4ID", Context.MODE_PRIVATE);
        mvalor = mprefs.getString("variable","Valor default");

        ((TextView)findViewById(R.id.textView4)).setText(
                getString(R.string.activity_main_text_view_greeting, "Erick","Cordero"));

        tec = createImageOnSDCard(R.drawable.tec);

    }

    @Override
    protected void onStart() {

        super.onStart();
        
        //print de prueba
        Log.d(" CREATION","onStart");
    }

    @Override
    protected void onResume() {

        super.onResume();

        //print de prueba
        Log.d(" CREATION","onResume");

        //valor para mostrar
        TextView textView = findViewById(R.id.textView2);
        textView.setText(mvalor);
    }

    @Override
    protected void onPause() {

        super.onPause();

        //print de prueba
        Log.d(" CREATION","onPause");
    }

    @Override
    protected void onStop() {

        super.onStop();

        //print de prueba
        Log.d(" CREATION","onStop");

        mvalor = null;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        //print de prueba
        Log.d(" CREATION","onDestroy");

        //se guarda el valor
        SharedPreferences.Editor editor = mprefs.edit();
        editor.putString("variable", "Holaaaaaaaaaa no soy Raul");
        editor.commit();

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void shareImage(View view){
        Uri path = FileProvider.getUriForFile(this, "com.example.eguic.myfirstapp", new File(tec));

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "This is one image I'm sharing.");
        shareIntent.putExtra(Intent.EXTRA_STREAM, path);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share..."));

    }

    /**
     * Create an image on the phone's SD card to later be able to share it.
     *
     * @param resID resource ID of an image coming from the res folder.
     * @return Return the path of the image that was created on the phone SD card.
     */
    private String createImageOnSDCard(int resID) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resID);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + resID + ".jpg";
        File file = new File(path);
        try {
            OutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file.getPath();
    }

}
