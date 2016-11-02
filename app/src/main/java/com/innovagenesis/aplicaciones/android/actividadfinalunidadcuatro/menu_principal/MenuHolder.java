package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.menu_principal;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.R;

/**
 * Encanrgada de Llenar el menu principal mediante un recycleView y un CardView
 * Created by Alexis on 1/11/2016.
 */

class MenuHolder extends RecyclerView.ViewHolder {

    TextView titulo, descripcion;
    ImageView imgItem;
    CardView contenedor;



    MenuHolder(View itemView) {
        super(itemView);

        imgItem = (ImageView)itemView.findViewById(R.id.imgMenu);
        titulo = (TextView)itemView.findViewById(R.id.txtTitulo);
        descripcion = (TextView)itemView.findViewById(R.id.txtDescripcion);
        contenedor = (CardView)itemView.findViewById(R.id.cardview);
    }
}
