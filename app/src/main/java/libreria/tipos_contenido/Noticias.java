package libreria.tipos_contenido;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.jhon.okonexionmetro.R;

import libreria.complementos.Util;
import libreria.conexion.CargarImagen;
import libreria.sistema.App;
import libreria.sistema.ControladorBaseDatos;

/**
 * Created by Jhon on 26/03/2015.
 */
public class Noticias {

    Activity activity;

    public Noticias(Activity activity)
    {
     this.activity=activity;
    }


    public void cargar(){
        ControladorBaseDatos dbc = new ControladorBaseDatos(activity, ControladorBaseDatos.nombreDB, null, 1);
        SQLiteDatabase db = dbc.getReadableDatabase();

        TableLayout contenedor = (TableLayout) activity.findViewById(R.id.tab_contenedor_noticias);
        contenedor.setBackground(new ColorDrawable(Color.parseColor(App.colorBarraApp)));


        Cursor noticias = db.rawQuery("SELECT * FROM noticias", null);


        if (noticias.moveToFirst()) {

            int n = 0;
            TableRow fila = null;
            Point pantalla= Util.obtenerTamanoPantalla(activity);
            //Calcula las dimensiones de la imagen de la noticia
            int ancho_imagen=Math.round(pantalla.x/2);
            int altura_imagen=Math.round((App.H_IMAGEN_NOTICIA*ancho_imagen)/App.W_IMAGEN_NOTICIA);

            do {

                n++;

                String titulo = noticias.getString(2);
                String URL_imagen = noticias.getString(4);

                //TITULO DE LA NOTICIA
                TextView txt_titulo = new TextView(activity);
                txt_titulo.setText(titulo);
                txt_titulo.setTextColor(Color.parseColor(App.colorNombreApp));
                txt_titulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                txt_titulo.setGravity(Gravity.CENTER);


                if (n % 2 != 0) {
                    fila = new TableRow(activity);
                    fila.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_2)));
                }

                LinearLayout lay_noticia = new LinearLayout(activity);
                lay_noticia.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_2)));
                lay_noticia.setOrientation(LinearLayout.VERTICAL);
                lay_noticia.setGravity(Gravity.BOTTOM);



                LinearLayout lay_titulo = new LinearLayout(activity);

                lay_titulo.setOrientation(LinearLayout.VERTICAL);
                lay_titulo.setGravity(Gravity.BOTTOM);
                lay_titulo.setBackground(new ColorDrawable(Color.parseColor(App.colorBarraApp)));
                lay_titulo.setAlpha(0.7f);


                //SI la Noticia tiene imagen
                if(URL_imagen.length()>0 && Util.verificarConexion(activity)) {
                    //Carga la imagen de la noticia en el layour contenedor de fondo
                    new CargarImagen(activity, URL_imagen, lay_noticia).execute();

                    lay_titulo.addView(txt_titulo, LinearLayout.LayoutParams.MATCH_PARENT, (int) (altura_imagen / 3.5));
                    lay_noticia.addView(lay_titulo, LinearLayout.LayoutParams.MATCH_PARENT, (int) (altura_imagen / 3.5));
                }else{
                    LinearLayout.LayoutParams pm= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    pm.setMargins(10, 10, 10, 10);
                    lay_titulo.addView(txt_titulo,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    lay_titulo.setPadding(5,5,5,5);
                    lay_noticia.addView(lay_titulo, pm);
                }

                fila.addView(lay_noticia,ancho_imagen,altura_imagen);

                if (n % 2 != 0)
                    contenedor.addView(fila,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);



            } while (noticias.moveToNext());

        }


        db.close();
    }

}
