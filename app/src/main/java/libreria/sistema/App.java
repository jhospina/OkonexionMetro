package libreria.sistema;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;

import com.example.jhon.okonexionmetro.R;

/**
 * Created by Jhon on 24/03/2015.
 */
public class App {
    public static final String KEY_APP = "I2uqHDXS3RR8lgmaCOG9eZmcO15w7O6x0kxFoKYfbpbCLDdNR"; // Indica la llave unica de identificación de la aplicacion
    public static int base_info_version = 0; //Indica la versión de la informacion base

    /**
     * *******************************************************
     * CONFIGURACION DE BASICA DE LA APLICACION (MODIFICABLE)
     * ******************************************************
     */
    public static String nombreApp = "Okonexion";
    public static String colorBarraApp = "#000000";
    public static String colorNombreApp = "#FFFFFF";
    public static String mostrarNombre = "textoLogo";
    public static String alineacionNombre = "izquierda";
    public static String txt_menuBtn_1 = "Institucional";
    public static String txt_menuBtn_2 = "Noticias";
    public static String txt_menuBtn_3 = "Encuestas";
    public static String txt_menuBtn_4 = "PQR";
    public static String txt_menuBtn_1_color = "#000000";
    public static String txt_menuBtn_2_color = "#000000";
    public static String txt_menuBtn_3_color = "#000000";
    public static String txt_menuBtn_4_color = "#000000";
    public static String colorFondoMenuBt_1 = "#FFFFFF";
    public static String colorFondoMenuBt_2 = "#FFFFFF";
    public static String colorFondoMenuBt_3 = "#FFFFFF";
    public static String colorFondoMenuBt_4 = "#FFFFFF";




    /**
     * *******************************************************
     * URLS DE DESCARGAR DE INFORMACION
     * ******************************************************
     */

    public static final String URL_DESCARGAR_NOTICIAS = "http://okonexion.com/upanel/public/app/descargar/noticias";
    public static final String URL_DESCARGAR_INSTITUCIONAL = "http://okonexion.com/upanel/public/app/descargar/institucional";



    /**
     * *******************************************************
     * VARIABLES DE CONTROL
     * ******************************************************
     */

    //****NOTICIAS*****//
    public static boolean noticias_descargadas =false; //Indica si las noticias ya fueron descargadas
    public static int noticias_cantidad_a_cargar=16;//Indica el numero de noticias a cargar
    public static int noticias_cargadas=0;
    //****INSTITUCIONAL*****//
    public static boolean institucional_descargadas =false; //Indica si la informacion institucional ya fueron descargadas
    public static int institucional_cantidad_a_cargar=16;//Indica el numero de informacion institucional a cargar
    public static int institucional_cargadas=0;

  public static boolean descarga_iniciada=false;//Indica si existe un descarga iniciada



    /**
     * *******************************************************
     * VARIABLES DE DEFINCION DE DATOS
     * ******************************************************
     */

    public static final String CONFIG_MOSTRAR_NOMBRE_SOLOTEXTO = "soloTexto";
    public static final String CONFIG_MOSTRAR_NOMBRE_TEXTOLOGO = "textoLogo";
    public static final String CONFIG_MOSTRAR_NOMBRE_SOLOLOGO = "soloLogo";
    public static final int W_IMAGEN_NOTICIA=621;
    public static final int H_IMAGEN_NOTICIA=483;
    public static final int FACTOR_ACERCAMIENTO_SCROLL=15; //Indica el factor de acercamiento para cargar mas contenido al bajar el scroll

    public static int id_mensaje_no_hay_contenido=7738283;


    /**
     * *******************************************************
     * DEFINICION DE TEXTOS
     * ******************************************************
     */

    public static String mensaje_titulo_sin_conexion="SIN CONEXION";
    public static String mensaje_descripcion_sin_conexion="No es posible conectarse al servidor.";
    public static String mensaje_cargando="Cargando, por favor espere...";
    public static String mensaje_fecha_publicacion="Publicado el";
    public static String mensaje_no_hay_contenido="No hay contenido para mostrar";


    /**
     * Establece la configuraciòn de apariencia dada por la configuracion de las variables de la App
     *
     * @param activity
     */
    public static void establecerBarraAccion(ActionBarActivity activity,String titulo) {


        //*************************************************************
        // BARRA DE ACCIÒN DEL A APLICACION***************************
        //*************************************************************

        //Establece el color de fondo de la barra App
        activity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(App.colorBarraApp)));
        //Establece el color del texto de la barra
        activity.getSupportActionBar().setTitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + App.nombreApp+"</font>"));

        /**NOTA: Alineación del texto y el logo de barra aun no soportado**/


        //Indica que mostrar en la barra de accion
        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_SOLOTEXTO) {
            activity.getSupportActionBar().setDisplayUseLogoEnabled(false);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
            if(titulo!=null) {
                activity.getSupportActionBar().setSubtitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + titulo+"</font>"));
            }
        }

        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_TEXTOLOGO) {
            activity.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            activity.getSupportActionBar().setDisplayUseLogoEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(true);
            if(titulo!=null) {
                activity.getSupportActionBar().setSubtitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + titulo+"</font>"));
            }
        }

        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_SOLOLOGO) {
            activity.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            activity.getSupportActionBar().setDisplayUseLogoEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


    }


}
