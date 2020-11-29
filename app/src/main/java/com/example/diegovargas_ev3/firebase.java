package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import Clases.Clientes;

public class firebase extends AppCompatActivity {

    private EditText Nombre, Destino, Promocion;
    private Button Boton;
    FirebaseDatabase  firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        inicializarFirebase();

        Nombre = (EditText)findViewById(R.id.nombre);
        Destino = (EditText)findViewById(R.id.destino);
        Promocion = (EditText)findViewById(R.id.promocion);
        Boton = (Button)findViewById(R.id.guardar);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Nombre.equals("") & Destino.equals("") & Promocion.equals("")){
                    Clientes c = new Clientes();
                    c.setId(UUID.randomUUID().toString());
                    c.setNombre(Nombre.getText().toString());
                    c.setDestino(Destino.getText().toString());
                    c.setPromocion(Promocion.getText().toString());

                    databaseReference.child("Clientes").child(c.getId()).setValue(c);

                    Toast.makeText(getBaseContext(), "Se ha guardado correctamente", Toast.LENGTH_LONG).show();

                    Nombre.setText("");
                    Destino.setText("");
                    Promocion.setText("");
                }
                else
                {
                    Toast.makeText(getBaseContext(), "No se ha guardado correctamente, por favor rellene los campos correctamente", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void lista(View v)
    {
        Intent i = new Intent(this, listado_clientes.class);
        startActivity(i);
    }
}