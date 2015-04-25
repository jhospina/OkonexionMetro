package com.example.jhon.okonexionmetro;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import libreria.complementos.Mensaje;
import libreria.complementos.Util;
import libreria.conexion.Conexion;
import libreria.conexion.DescargarInstitucional;
import libreria.sistema.App;
import libreria.tipos_contenido.Institucional;


public class InstitucionalActivity extends ActionBarActivity {

   ScrollView scroll=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institucional);

        scroll = (ScrollView) findViewById(R.id.scroll_institucional);
        scroll.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_1)));

        App.establecerBarraAccion(this, App.txt_menuBtn_1);

        init();

        if (!App.institucional_descargadas) {

            if (!Conexion.verificar(this)) {
                Mensaje.alerta(this, App.mensaje_titulo_sin_conexion, App.mensaje_descripcion_sin_conexion);
                cargarInstitucional();
                App.institucional_descargadas = true;
            } else {
                ProgressDialog progress = new ProgressDialog(this);
                progress.setMessage(App.mensaje_cargando);
                new DescargarInstitucional(progress, this, R.id.tab_contenedor_institucional).execute();
            }

        } else {
            cargarInstitucional();
            App.institucional_descargadas = true;
        }
    }


    public void init(){
        App.institucional_cargadas=0;
    }




    public void cargarInstitucional(){
        Institucional institucional = new Institucional(this);
        institucional.cargar(R.id.tab_contenedor_institucional);
    }

}



