package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Lienzo extends AppCompatActivity {

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienzo);

        Bundle idSeleccion = getIntent().getExtras();
        id = idSeleccion.getInt("idSeleccion");

        this.setTitle("position " + id);

        LienzoCanvas lienzoCanvas = new LienzoCanvas(this);
        setContentView(lienzoCanvas);
    }
}

class LienzoCanvas extends View{

    Context context;
    Lienzo lienzo = new Lienzo();

    public LienzoCanvas(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int id = lienzo.id;
        Toast.makeText(context,"La posicion es : " + id,Toast.LENGTH_SHORT).show();

    }
}