package libreria.conexion;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import libreria.complementos.Util;

/**
 * Created by Jhon on 26/03/2015.
 */
public class CargarImagen extends AsyncTask<String, Void, Bitmap> {

        private String URL;
        private LinearLayout imagen;
        private LinearLayout contenedor;
        private Context contexto;

        public CargarImagen(Context contexto,String URL,LinearLayout imagen){
            this.contexto=contexto;
            this.URL=URL;
            this.imagen=imagen;
        }


        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap imagen = Util.descargarImagen(this.URL);
            return imagen;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            Drawable img=new BitmapDrawable(contexto.getResources(),result);
            imagen.setBackground(img);
        }

    }

