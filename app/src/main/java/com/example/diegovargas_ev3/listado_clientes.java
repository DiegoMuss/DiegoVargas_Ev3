package com.example.diegovargas_ev3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;

public class listado_clientes extends AppCompatActivity {

    private ListView Lista;

    private List<Clientes> listaClientes = new ArrayList<Clientes>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes);

        inicialisarBase();

        Lista = (ListView)findViewById(R.id.lista);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes c = objSnapshot.getValue(Clientes.class);

                    listaClientes.add(c);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaClientes);
                    Lista.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                seleccion = (Clientes) adapterView.getItemAtPosition(i);
            }
        });
    }

    public void eliminar(View view)
    {
        Clientes c = new Clientes();
        c.setId(seleccion.getId());

        databaseReference.child("Clientes").child(c.getId()).removeValue();

        Toast.makeText(getBaseContext(), "Cliente eliminado Correctamente", Toast.LENGTH_LONG).show();
    }

    public void inicialisarBase ()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}