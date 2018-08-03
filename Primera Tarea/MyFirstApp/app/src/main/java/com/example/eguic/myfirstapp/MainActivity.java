package com.example.eguic.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public String mvalor;
    public SharedPreferences mprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //print de prueba
        Log.d(" CREATION","onCreate");
        setContentView(R.layout.activity_main);
        mvalor = "Hola";
        mprefs = getSharedPreferences("SOA4ID", Context.MODE_PRIVATE);
        mvalor = mprefs.getString("variable","Valor default");
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
}
