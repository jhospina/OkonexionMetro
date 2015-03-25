package com.example.jhon.okonexionmetro;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import libreria.sistema.App;


public class MenuPrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_principal);

        App.establecerBarraAccion(this);

       establecerApariencia();

/*
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Cargando aplicación, por favor espere...");
        new CargarConfiguracion(progress, this).execute();*/

    }


    private void establecerApariencia(){
        //Obtiene el componente Layout del Boton 1 "Institucional"
        LinearLayout layoutMenu1 = (LinearLayout) findViewById(R.id.lay_menu1);
        //Obtiene el componente Layout del Boton 2 "Noticias"
        LinearLayout layoutMenu2 = (LinearLayout) findViewById(R.id.lay_menu2);
        //Obtiene el componente Layout del Boton 3 "Encuestas"
        LinearLayout layoutMenu3 = (LinearLayout) findViewById(R.id.lay_menu3);
        //Obtiene el componente Layout del Boton 4 "PQR"
        LinearLayout layoutMenu4 = (LinearLayout) findViewById(R.id.lay_menu4);

        TableLayout contenedor=(TableLayout)findViewById(R.id.contenedor_menu_principal);
        contenedor.setBackground(new ColorDrawable(Color.parseColor(App.colorBarraApp)));

        layoutMenu1.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_1)));
        layoutMenu2.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_2)));
        layoutMenu3.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_3)));
        layoutMenu4.setBackground(new ColorDrawable(Color.parseColor(App.colorFondoMenuBt_4)));

        TextView txt_menu_1=(TextView)findViewById(R.id.txt_menu1);
        TextView txt_menu_2=(TextView)findViewById(R.id.txt_menu2);
        TextView txt_menu_3=(TextView)findViewById(R.id.txt_menu3);
        TextView txt_menu_4=(TextView)findViewById(R.id.txt_menu4);

        txt_menu_1.setText(App.txt_menuBtn_1);
        txt_menu_2.setText(App.txt_menuBtn_2);
        txt_menu_3.setText(App.txt_menuBtn_3);
        txt_menu_4.setText(App.txt_menuBtn_4);

        //Color del texto de los botones del menu
        txt_menu_1.setTextColor(Color.parseColor(App.txt_menuBtn_1_color));
        txt_menu_2.setTextColor(Color.parseColor(App.txt_menuBtn_2_color));
        txt_menu_3.setTextColor(Color.parseColor(App.txt_menuBtn_3_color));
        txt_menu_4.setTextColor(Color.parseColor(App.txt_menuBtn_4_color));
    }

}



