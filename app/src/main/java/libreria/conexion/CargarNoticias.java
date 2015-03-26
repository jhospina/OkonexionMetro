package libreria.conexion;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.jhon.okonexionmetro.R;

import org.json.JSONException;
import org.json.JSONObject;

import libreria.complementos.Mensaje;
import libreria.complementos.Util;
import libreria.sistema.App;
import libreria.sistema.ControladorBaseDatos;
import libreria.tipos_contenido.Noticias;

/**
 * Created by Jhon on 24/03/2015.
 */
public class CargarNoticias extends AsyncTask<Void, Void, Void> {

    ProgressDialog progress;
    Activity activity;

    public CargarNoticias(ProgressDialog progress, Activity act) {
        this.progress = progress;
        this.activity = act;
    }

    public void onPreExecute() {
        progress.show();
        //aquí se puede colocar código a ejecutarse previo


    }

    public void onPostExecute(Void unused) {
        Noticias noticias=new Noticias(activity);
        noticias.cargar();
        progress.dismiss();
    }


    /**
     *  SE CONECTA AL SERVIDOR PARA OBTENER DE LAS NOTICIAS
     *  *
     */


    protected Void doInBackground(Void... params) {

        //Prepara los datos para enviar al servidor, como peticion envia la KEY_APP de la aplicacion
        String[][] datos = new String[1][2];
        datos[0][0] = "key_app";
        datos[0][1] = App.KEY_APP;

        //Se conecta al servidor para obtener los datos de la aplicacion
        JSONObject datosJSON = Util.conectar(App.URL_CONFIG, datos);

        try {
            //Obtiene los datos de las noticias extraida del JSON de los datos
            JSONObject noticias = new JSONObject(datosJSON.getString("noticias"));
            ControladorBaseDatos dbc = new ControladorBaseDatos(activity, ControladorBaseDatos.nombreDB, null, 1);
            SQLiteDatabase db = dbc.getWritableDatabase();

            if (db != null) {
                //Ingresa los datos de las noticias localmente si no existen
                for (int i = 0; i < noticias.length() / 4; i++)
                    if (!ControladorBaseDatos.existeRegistro(db, "noticias", "id_noticia", noticias.getString("id" + (i + 1)))) {
                        db.execSQL("INSERT INTO noticias (id_noticia,titulo,descripcion,imagen) VALUES (" + noticias.getString("id" + (i + 1)) + ",'" + noticias.getString("titulo" + (i + 1)) + "','" + noticias.getString("descripcion" + (i + 1)).replaceAll("'", "\"") + "','" + noticias.getString("imagen" + (i + 1)) + "')");
                    }

                //Cerramos la base de datos
                db.close();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}
