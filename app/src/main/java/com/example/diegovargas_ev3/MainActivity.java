package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
    }

    public void menu(View v)
    {
        String usuario = user.getText().toString();
        int contraseña = Integer.parseInt(pass.getText().toString());

        if(usuario.equals("ANDROID") || usuario.equals("Android") && contraseña == 123)
        {
            Intent i = new Intent(this, menu.class);
            startActivity(i);

            user.setText("");
            pass.setText("");

            Toast.makeText(getBaseContext(), "Sesion iniciada", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Datos de inicio de sesion incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}