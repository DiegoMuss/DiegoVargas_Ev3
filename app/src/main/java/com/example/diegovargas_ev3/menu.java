package com.example.diegovargas_ev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        videoView = (VideoView)findViewById(R.id.videov);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);

        videoView.start();
    }

    public void firebase(View v)
    {
        Intent i = new Intent(this, firebase.class);
        startActivity(i);
    }

    public void listado(View v)
    {
        ArrayList<String> listaPromo = new ArrayList<>();

        listaPromo.add("Ramiro");
        listaPromo.add("Rosa");
        listaPromo.add("Robert");

        Intent i = new Intent(this, promociones.class);

        i.putExtra("listaPromociones", listaPromo);

        startActivity(i);
    }
}