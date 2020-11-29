package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void firebase(View v)
    {
        Intent i = new Intent(this, firebase.class);
        startActivity(i);
    }

    public void listado(View v)
    {
        Intent i = new Intent(this, promociones.class);
        startActivity(i);
    }
}