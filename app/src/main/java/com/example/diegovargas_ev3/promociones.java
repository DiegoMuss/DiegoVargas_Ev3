package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;

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
        String cliente = spinner.getSelectedItem().toString();
        String promo = Promocion.getText().toString();
        int envio = Integer.parseInt(Envio.getText().toString());
        int resultado;

        Promociones promociones = new Promociones();

        if(promo.toLowerCase().equals("pizzas promo"))
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

        /*if(!Promocion.equals("") & Envio.equals(""))
        {
            String promo = Promocion.getText().toString();
            int envio = Integer.parseInt(Envio.getText().toString());
            int resultado;

            if(promo.toLowerCase().equals("pizzas promo"))
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
        }
        else
        {
            text1.setText("Debe ingresar un datos validos");
        }*/
    }
}