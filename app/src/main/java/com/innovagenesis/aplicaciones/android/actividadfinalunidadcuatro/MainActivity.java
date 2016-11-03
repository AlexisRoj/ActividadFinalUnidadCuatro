package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro.menu_principal.MenuAdapters;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Instancia el recycleView y sus elementos*/
        MenuAdapters adapters = new MenuAdapters(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setAdapter(adapters);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
