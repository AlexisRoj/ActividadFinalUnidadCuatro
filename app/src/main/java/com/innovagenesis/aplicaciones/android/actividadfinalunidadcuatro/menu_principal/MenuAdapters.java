package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.menu_principal;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.Lienzo;
import com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.R;

/**
 * Clase encargada de alimentar el menu principal
 * Created by Alexis on 1/11/2016.
 */

public class MenuAdapters extends RecyclerView.Adapter<MenuHolder> {

    private final static String idSeleccion = "idSeleccion";
    private Context context;
    private LayoutInflater inflater;

    /** Variables encargadas de recibir los array*/

    private String[] titulos;
    private String[] descripciones;
    private TypedArray imgMenu;

    public MenuAdapters(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);

        /** Es necesario inicializarlos en el contructor*/
        titulos = context.getResources().getStringArray(R.array.titulos);
        descripciones = context.getResources().getStringArray(R.array.descripcion);
        imgMenu = context.getResources().obtainTypedArray(R.array.imgMenu);

    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_menu, parent, false);
        return new MenuHolder(view);

    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {

        /** Llenado de RecycleView */
        holder.imgItem.setImageResource(imgMenu.getResourceId(position, 0));
        holder.titulo.setText(titulos[position]);
        holder.descripcion.setText(descripciones[position]);
        holder.contenedor.setOnClickListener(onClickListener);
        holder.contenedor.setTag(holder);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MenuHolder recycleViewHolder = (MenuHolder) v.getTag();
            int position = recycleViewHolder.getAdapterPosition();


            /** Ejecuta el lienzo*/
            Intent intent = new Intent(context, Lienzo.class);
            intent.putExtra(idSeleccion,position);
            context.startActivity(intent);

          //  Toast.makeText(context,"La posicion es : " + position,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getItemCount() {
        return titulos.length;
    }
}
