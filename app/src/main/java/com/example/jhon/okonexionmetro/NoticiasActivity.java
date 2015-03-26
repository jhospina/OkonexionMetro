package com.example.jhon.okonexionmetro;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import libreria.complementos.Mensaje;
import libreria.complementos.Util;
import libreria.conexion.CargarNoticias;
import libreria.sistema.App;
import libreria.tipos_contenido.Noticias;


public class NoticiasActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

       App.establecerBarraAccion(this, App.txt_menuBtn_2);


        if(!App.cargaNoticias) {

            if (!Util.verificarConexion(this)) {
                Mensaje.alerta(this, "SIN CONEXIÓN", "No es posible conectarse al servidor.");
                Noticias noticias=new Noticias(this);
                noticias.cargar();
            } else {
                ProgressDialog progress = new ProgressDialog(this);
                progress.setMessage("Cargando " + App.txt_menuBtn_2 + ", por favor espere...");
                new CargarNoticias(progress, this).execute();
            }

            App.cargaNoticias=true;
        }else{
            Noticias noticias=new Noticias(this);
            noticias.cargar();
            App.cargaNoticias=true;
        }

    }

}



