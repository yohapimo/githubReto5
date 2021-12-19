package com.example.reto5festibom.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.reto5festibom.R;
import com.example.reto5festibom.Vista.Fragment_Favoritos;
import com.example.reto5festibom.Vista.Fragment_Inicio;
import com.example.reto5festibom.Vista.Fragment_Productos;
import com.example.reto5festibom.Vista.Fragment_Servicios;
import com.example.reto5festibom.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    Fragment subPantalla1, subPantalla2, subPantalla3, subPantalla4, subPantallaInicio;
    FragmentTransaction trasaction;
    Button boton1, boton2, boton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_Productos();
        subPantalla2 = new Fragment_Servicios();
        subPantalla3 = new Fragment_Sucursales();
        subPantalla4 = new Fragment_Favoritos();
        subPantallaInicio = new Fragment_Inicio();

        // Llamamos la pantalla Inicio
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();

        // Creamos los objetos boton
        boton1 = (Button)findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasaction = getSupportFragmentManager().beginTransaction();
                trasaction.replace(R.id.contenedor_fragments, subPantalla1).commit();

            }

        });

        boton2 = (Button)findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasaction = getSupportFragmentManager().beginTransaction();
                trasaction.replace(R.id.contenedor_fragments, subPantalla2).commit();

            }
        });

        boton3 = (Button)findViewById(R.id.boton3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasaction = getSupportFragmentManager().beginTransaction();
                trasaction.replace(R.id.contenedor_fragments, subPantalla3).commit();

            }
        });
    }
    //******************************* MENU DE OPCIONES *********************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos){
            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.servicios){
            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.contenedor_fragments, subPantalla2).commit();

        }
        if (id == R.id.sucursales){
            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.contenedor_fragments, subPantalla3).commit();

        }
        if (id == R.id.favoritos){
            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.contenedor_fragments, subPantalla4).commit();

        }

        return super.onOptionsItemSelected(item);
    }

}
