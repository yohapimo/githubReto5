package com.example.reto5festibom.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto5festibom.Modelo.Adaptador;
import com.example.reto5festibom.Modelo.Entidad;
import com.example.reto5festibom.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_Productos extends Fragment {

    int [] imagen = {R.drawable.productofamiliar_1, R.drawable.productoempresa_2 };

    String TAG = "Fragment_Productos";

    View v;

    ListView listaProductos;
    Adaptador adaptador;

    TextView prueba;

    // CONEXION A LA BASE DE DATOS: instancia APEX de SQL en Oracle Cloud

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(GetTablaProductos(), getContext());

        listaProductos.setAdapter(adaptador);

        prueba = (TextView) v.findViewById(R.id.prueba2);

        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> GetTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        /* ******************************************************************************** */

        // String url = "https://reqres.in/api/users?page=2";
        String url = "https://gc2648324623f36-festibom.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");

                        listaProductos.add(new Entidad(imagen[i], titulo, descripcion));
                        prueba.append(" " + '\n');

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { error.printStackTrace(); }
        });

        requestQueue.add(jsonObjectRequest);

        /* ******************************************************************************** */

        return listaProductos;
    }

}