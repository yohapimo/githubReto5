package com.example.reto5festibom.Vista;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.reto5festibom.Controlador.MainActivity;
import com.example.reto5festibom.R;

public class SplashScreen extends AppCompatActivity implements Runnable{

    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView bom = (ImageView)findViewById(R.id.bom);
        bom.setBackgroundResource(R.drawable.bom);

        AnimationDrawable ejecutarAnimacion = (AnimationDrawable)bom.getBackground();
        ejecutarAnimacion.start();

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            // Aqui valida si hay conexión a internet.
            // Aqui valida que haya conexión con Oracle Cloud.
            // Aqui valida que haya carge de mapas.

            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}