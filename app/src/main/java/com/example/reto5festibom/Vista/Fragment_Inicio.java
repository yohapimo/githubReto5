package com.example.reto5festibom.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.reto5festibom.R;

public class Fragment_Inicio extends Fragment {

    Drawable drawable8;
    ImageView imagen8;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__inicio, container, false);
        // ------------------------------------------------------------------------------------


        //------------------------INSERTAMOS IMAGEN EN FRAGMENT INICIO ----------------------------
        Resources res8 = getResources();
        drawable8 = res8.getDrawable(R.drawable.logoempresa_9, v.getContext().getTheme());

        imagen8 = (ImageView) v.findViewById(R.id.imagen8);
        imagen8.setImageDrawable(drawable8);

        //---------------------------------------------------------------

        // ------------------------------------------------------------------------------------

        return v;
    }

}