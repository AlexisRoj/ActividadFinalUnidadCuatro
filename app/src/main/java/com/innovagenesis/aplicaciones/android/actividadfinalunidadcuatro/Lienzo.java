package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*****************************************************/
/** CLASE LIENZO ENCARGADA DE ALBERGAR LOS DIBUJOS  **/
/*****************************************************/

public class Lienzo extends AppCompatActivity {

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienzo);

        Bundle idSeleccion = getIntent().getExtras();
        id = idSeleccion.getInt("idSeleccion");

        String[] titulo = getResources().getStringArray(R.array.formas);
        this.setTitle(titulo[id]);

        /**Se trae el id desde el RecycleView y se lleva al canvas por el contructor*/
        LienzoCanvas lienzoCanvas = new LienzoCanvas(this, id);
        setContentView(lienzoCanvas);
    }
}

/*****************************************************/
/** CLASE CANVAS ENCARGADA DE GESTIONAR LOS DIBUJOS **/
/*****************************************************/

class LienzoCanvas extends View {

    /** Lienzo de trabajo del Canvas*/
    int id;

    public LienzoCanvas(Context context) {
        super(context);
    }

    public LienzoCanvas(Context context, int id) {
        super(context);
        this.id = id;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int ejeX = 0, ejeY = 0;
        /** Array de recursos con los nombres de las formas*/
        String[] formas = getContext().getResources().getStringArray(R.array.formas);

        /** Inicializacion del lienzo*/
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        /** Al color con el que se va a pintar se le asigna el color de la region*/
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));

        ejeX = 150;
        ejeY = 300;

        switch (id) {

            case 0:
                /** Circulo */
                canvas.drawOval(ejeX, ejeY, 200 + ejeX, 200 + ejeY, paint);
                break;
            case 1:
                /** Ovalo */
                canvas.drawOval(ejeX, ejeY, 200 + ejeX, 150 + ejeY, paint);
                break;
            case 2:
                /** Cuadrado */
                canvas.drawRect(ejeX, ejeY, 200 + ejeX, 200 + ejeY, paint);
                break;
            case 3:
                /** Rectangulo */
                canvas.drawRect(ejeX, ejeY, 200 + ejeX, 150 + ejeY, paint);
                break;
            case 4:
                /** Libre */
                break;
        }

        Toast.makeText(getContext(), formas[id], Toast.LENGTH_SHORT).show();
    }
}