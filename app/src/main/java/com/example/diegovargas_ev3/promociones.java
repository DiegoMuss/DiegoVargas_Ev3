package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Promociones;

public class promociones extends AppCompatActivity {

    private EditText Promocion, Envio;
    private TextView text1, text2;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        Promocion = (EditText)findViewById(R.id.promocion);
        Envio = (EditText)findViewById(R.id.envio);
        text1 = (TextView) findViewById(R.id.tv1);
        text2 = (TextView) findViewById(R.id.tv2);
        spinner = (Spinner)findViewById(R.id.spin);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaPromociones");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);

        spinner.setAdapter(adapt);
    }

    public void calcular (View view)
    {
        Promociones promociones = new Promociones();

        String cliente = spinner.getSelectedItem().toString();

        String promo = Promocion.getText().toString();
        promo = promo.toLowerCase();

        String valor = Envio.getText().toString();
        int resultado;

        if(promo.isEmpty() || valor.isEmpty())
        {
            Toast.makeText(getBaseContext(), "Los campos no pueden quedar vacios", Toast.LENGTH_LONG).show();
        }
        else
        {
            int envio = Integer.parseInt(valor);

            if(promo.toLowerCase().equals("pizza promo"))
            {
                resultado = promociones.getPizzaPromo() + envio;
                text1.setText("Estimado "+ cliente +", el valor final segun promocion y envio es:");
                text2.setText("$"+resultado);
            }
            else if(promo.toLowerCase().equals("master promo"))
            {
                resultado = promociones.getMasterPizza() + envio;
                text1.setText("Estimado "+ cliente +", el valor final segun promocion y envio es:");
                text2.setText("$"+resultado);
            }
            else if(promo.toLowerCase().equals("pizza max"))
            {
                resultado = promociones.getPizzaMax() + envio;
                text1.setText("Estimado "+ cliente +", el valor final segun promocion y envio es:");
                text2.setText("$"+resultado);
            }
            else
            {
                Toast.makeText(getBaseContext(), "Debe ingresar una promocion valida", Toast.LENGTH_LONG).show();
            }
        }
    }
}