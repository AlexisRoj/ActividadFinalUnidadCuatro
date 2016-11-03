package com.innovagenesis.aplicaciones.android.actividadfinalunidadcuatro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
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

        /** Trae el id del RecycleView*/
        Bundle idSeleccion = getIntent().getExtras();
        id = idSeleccion.getInt("idSeleccion");

        /** Cambia el titulo de la barra*/
        String[] titulo = getResources().getStringArray(R.array.formas);
        this.setTitle(titulo[id]);

        /** Envia mensaje de ayuda, para realizar accion en pantalla*/
        String [] ayudaForma = getResources().getStringArray(R.array.ayudaForma);
        Toast.makeText(this,ayudaForma[id], Toast.LENGTH_SHORT).show();

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
    /** Coordenadas de ejes x y y, se declaran inferiores a 100, para evitar dos formas en
     * el primer touch*/
    float ejeX = -100;
    float ejeY = -100;


    /** Inicializacion del lienzo*/
    Path path = new Path();
    Paint paint = new Paint();

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

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        /** Al color con el que se va a pintar se le asigna el color de la region*/
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));


        canvas.drawPath(path, paint);

        switch (id) {
            case 0:
                /** Circulo */
                path.addOval(ejeX, ejeY, 80 + ejeX, 80 + ejeY, Path.Direction.CW);
                break;
            case 1:
                /** Ovalo */
                path.addOval(ejeX, ejeY, 60 + ejeX, 100 + ejeY, Path.Direction.CW);
                break;
            case 2:
                /** Cuadrado */
                path.addRect(ejeX, ejeY, 80 + ejeX, 80 + ejeY, Path.Direction.CW);
                break;
            case 3:
                /** Rectangulo */
                path.addRect(ejeX, ejeY, 60 + ejeX, 100 + ejeY, Path.Direction.CW);
                break;
            case 4:
                /** Estilo libre, se utiliza  un oval porque es mas divertido usarlo */
                path.addOval(ejeX, ejeY, 20 + ejeX, 20 + ejeY, Path.Direction.CW);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (id == 4) {
            /** Funciona de acuerdo a la seleccion del menu principal*/
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                /** Crea el el trazo de la liena*/
                ejeX = event.getX();
                ejeY = event.getY();
            }
        } else {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                /** Imprime figuras en pantalla, donde realiza el touch*/
                ejeX = event.getX();
                ejeY = event.getY();
            }
        }
        invalidate();
        return true;
    }

}