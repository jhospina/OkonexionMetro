package libreria.conexion;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import libreria.complementos.Util;
import libreria.sistema.App;
import libreria.sistema.ControladorBaseDatos;

/**
 * Created by Jhon on 24/03/2015.
 */
public class CargarConfiguracion extends AsyncTask<Void, Void, Void> {

    ProgressDialog progress;
    Activity activity;

    public CargarConfiguracion(ProgressDialog progress, Activity act) {
        this.progress = progress;
        this.activity = act;
    }

    public void onPreExecute() {
        progress.show();
        //aquí se puede colocar código a ejecutarse previo


    }

    public void onPostExecute(Void unused) {
//aquí se puede colocar código que
//se ejecutará tras finalizar
        progress.dismiss();
    }


    protected Void doInBackground(Void... params) {


        JSONObject datosJSON=Util.conectar(App.URL_CONFIG);

        try {

            JSONObject noticias=new JSONObject(datosJSON.getString("noticias"));

               Log.e("Dato ",noticias.getString("titulo1"));

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Error","ERROR");
        }

        ControladorBaseDatos dbc = new ControladorBaseDatos(this.activity, "okonexion", null, 1);

        SQLiteDatabase db = dbc.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {

           // JSONObject config= Util.conectar(App.URL_CONFIG);

            //Cerramos la base de datos
            db.close();
        }

        return null;
    }


}
