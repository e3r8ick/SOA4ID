package com.eguic.smssender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        String number = ((EditText) findViewById(R.id.phone)).getText().toString();
        String message = ((EditText) findViewById(R.id.messageText)).getText().toString();

        Intent inntent = new Intent(MainActivity.this, ActionReceiver.class);
        inntent.putExtra("number", number);
        inntent.putExtra("message", message);
        getApplicationContext().sendBroadcast(inntent);

        Context context = getApplicationContext();
        CharSequence text = "Mensaje enviado";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
