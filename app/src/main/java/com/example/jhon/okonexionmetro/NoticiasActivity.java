package com.example.jhon.okonexionmetro;

import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import libreria.complementos.Mensaje;
import libreria.complementos.Util;
import libreria.conexion.Conexion;
import libreria.conexion.DescargarNoticias;
import libreria.sistema.App;
import libreria.sistema.ControladorBaseDatos;
import libreria.tipos_contenido.Noticias;


public class NoticiasActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        App.establecerBarraAccion(this, App.txt_menuBtn_2);

        init();

        if (!App.noticias_descargadas) {

            if (!Conexion.verificar(this)) {
                Mensaje.alerta(this, App.mensaje_titulo_sin_conexion, App.mensaje_descripcion_sin_conexion);
                cargarNoticias();
                App.noticias_descargadas = true;
            } else {
                ProgressDialog progress = new ProgressDialog(this);
                progress.setMessage(App.mensaje_cargando);
                new DescargarNoticias(progress, this, R.id.tab_contenedor_noticias).execute();
            }

        } else {
            cargarNoticias();
            App.noticias_descargadas = true;
        }

        cargarMasNoticias();
    }


    public void init(){
        App.noticias_cargadas=0;
    }


    public void cargarMasNoticias() {

        final ScrollView scroll = (ScrollView) findViewById(R.id.scroll_noticias);
        final TableLayout tabla = (TableLayout) findViewById(R.id.tab_contenedor_noticias);
        final TableRow loading = (TableRow) findViewById(R.id.cargar_noticias);
        loading.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_2)));

        final Point pantalla= Util.obtenerTamanoPantalla(this);

        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Calcula si el scroll ha llegado al final y carga mas contenido si existe
                if (scroll.getScrollY() >= ((tabla.getHeight() - scroll.getHeight())-(pantalla.y/10))) {

                    if (Conexion.verificar(NoticiasActivity.this)) {
                        if (!App.descarga_iniciada) {
                            App.descarga_iniciada = true;
                            tabla.removeView(loading);
                            tabla.addView(loading);
                            loading.setVisibility(View.VISIBLE);
                            new DescargarNoticias(loading, NoticiasActivity.this, R.id.tab_contenedor_noticias).execute();
                        }
                    }else{
                        cargarNoticias();
                    }
                }
                return false;
            }
        });
    }


    public void cargarNoticias(){
        Noticias noticias = new Noticias(this);
        noticias.cargar(R.id.tab_contenedor_noticias);
    }

}



