package com.example.reto5festibom.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto5festibom.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto5festibom.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    public Adaptador(ArrayList<Entidad> itemLista, Context context) {
        this.itemLista = itemLista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemLista.size(); // Devuelve el número de metodos de la lista
    }

    @Override
    public Object getItem(int position) {
        return itemLista.get(position);  // Devuelve el item en donde vamos a trabajar
    }

    @Override

    public long getItemId(int position) {
        return 0; // no lo vamos a usar
    }

    /***
     * Este método es el más importante es donde se establecen los valores
     * por cada elemento visual del item, de forma similar a los fragments
     * @param position
     * @param v
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {

        Entidad datosItem = (Entidad) getItem(position);

        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //---------------------------------------------------------------------
        ImageView imagen = (ImageView) v.findViewById(R.id.imagen1_item);
        TextView titulo = (TextView) v.findViewById(R.id.titulo_item);
        TextView descripcion = (TextView) v.findViewById(R.id.descripcion_item);

        //---------------------------------------------------------------------------------
        conectar = new MotorBaseDatosSQLite(context,"TiendaProductos", null, 1);
        SQLiteDatabase db_escribir = conectar.getWritableDatabase();
        conectar.onUpgrade(db_escribir, 1, 2);
        //---------------------------------------------------------------------------------


        // Desde aqui no estoy pasando datos.
        // Si quiero usarlos los creo en la clase Entidad.
        // TextView descripcion2 = (TextView) v.findViewById(R.id.descripcion2_item);
        Button boton1 = (Button) v.findViewById(R.id.boton1_item);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Guardado en Favoritos", Toast.LENGTH_LONG).show();

                db_escribir.execSQL("INSERT INTO favoritos VALUES (0, '"+datosItem.getTitulo()+"', '"+datosItem.getTitulo()+"')");

            }
        });

        CheckBox favoritos = (CheckBox) v.findViewById(R.id.favorito_item);

        /*
        Pasar los datos desde la entidad a cada elemento visual del item.
         */

        imagen.setImageResource(datosItem.getImagen());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(context, "Item" + titulo.getText(), Toast.LENGTH_LONG).show();

            }
        });

        //---------------------------------------------------------------------
        return v;
    }
}
