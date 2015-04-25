package libreria.sistema;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;

import com.example.jhon.okonexionmetro.R;

import libreria.complementos.Util;
import libreria.extensiones.ComponenteInterfaz;

/**
 * Created by Jhon on 24/03/2015.
 */
public class App {
    public static final String KEY_APP = "I2uqHDXS3RR8lgmaCOG9eZmcO15w7O6x0kxFoKYfbpbCLDdNR"; // Indica la llave unica de identificación de la aplicacion

    /**
     * *******************************************************
     * CONFIGURACION DE BASICA DE LA APLICACION (MODIFICABLE)
     * ******************************************************
     */
    public static String nombreApp = "Okonexion";
    public static String colorBarraApp = "#CE0202";
    public static String colorNombreApp = "#FFFFFF";
    public static String mostrarNombre = "textoLogo";
    public static String alineacionNombre = "izquierda";
    public static String txt_menuBtn_1 = "Institucional";
    public static String txt_menuBtn_2 = "Noticias";
    public static String txt_menuBtn_3 = "Encuestas";
    public static String txt_menuBtn_4 = "PQRS";
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
     * DEFINICION DE TEXTOS (MODIFICABLE)
     * ******************************************************
     */

    public static String mensaje_titulo_sin_conexion = "SIN CONEXION";
    public static String mensaje_descripcion_sin_conexion = "No es posible conectarse al servidor.";
    public static String mensaje_cargando = "Cargando, por favor espere...";
    public static String mensaje_fecha_publicacion = "Publicado el";
    public static String mensaje_no_hay_contenido = "No hay contenido para mostrar";
    public static String mensaje_buscando_encuesta_vigente="Buscando encuesta vigente...";
    public static String mensaje_boton_enviar="Enviar";
    public static String mensaje_enviando="Enviando...";
    public static String mensaje_respuesta_enviada="Tu respuesta ha sido enviada. ¡Muchas gracias!";
    public  static String mensaje_ver_resultados="Ver resultados";
    public static String mensaje_encabezado_encuesta_vigente="Encuesta vigente";
    public static String mensaje_encabezado_responde_encuesta="Responde la encuesta";
    public static String mensaje_resultados ="Resultados";
    public static String mensaje_selecciona_respuesta ="Selecciona una respuesta";
    public static String mensaje_historial_encuestas="Historial de encuestas";
    public static String mensaje_no_hay_contenido_vuelve_mas_tarde="No hay contenido para mostrar, vuelve más tarde.";
    public static String txt_pqr_peticiones="Peticiones";
    public static String txt_pqr_quejas="Quejas";
    public static String txt_pqr_reclamos="Reclamos";
    public static String txt_pqr_sugerencias="Sugerencias";
    public static String txt_btn_crear_peticion="Crear una petición";
    public static String txt_btn_crear_queja="Enviar una queja";
    public static String txt_btn_crear_reclamo="Enviar un reclamo";
    public static String txt_btn_crear_sugerencia="Enviar una sugerencia";
    public static String txt_editText_nombre="¿Cuál es tu nombre?";
    public static String txt_editText_email="¿Cuál es tu email?";
    public static String txt_editText_asunto="¿Cúal es el asunto de este mensaje?";
    public static String txt_editText_descripcion_peticion="Describe tu petición aquí...";
    public static String txt_editText_descripcion_queja="Describe cual es tu queja aquí...";
    public static String txt_editText_descripcion_reclamo="Describe tu reclamo aquí...";
    public static String txt_editText_descripcion_sugerencia="Describe tu sugerencia aquí...";
    public static String txt_info_error="Error";
    public static String txt_info_nombre_error="Ingresa un nombre valido";
    public static String txt_info_email_error="Ingresa un correo electrónico valido";
    public static String txt_info_asunto_error="Ingresa un asunto para el mensaje";
    public static String txt_info_descripcion_error="Ingresa una descripción para el mensaje";
    public static String txt_info_peticion_enviada="Tu petición ha sido enviada, proximamente tendras una respuesta.";
    public static String txt_info_queja_enviada="Tu queja ha sido enviada, Muchas gracias.";
    public static String txt_info_reclamo_enviada="Tu reclamo ha sido enviado, pronto te constestaremos.";
    public static String txt_info_sugerencia_enviada="Gracias por enviarnos tu sugerencia. Estamos atentos para mejorar cada día. Muchas gracias.";
    public static String txt_info_informacion_enviada="Información enviada";
    public static String txt_btn_aceptar="Aceptar";
    public static String txt_info_mis_peticiones="Mis peticiones";
    public static String txt_info_mis_quejas="Mis quejas";
    public static String txt_info_mis_reclamos="Mis reclamos";
    public static String txt_info_mis_sugerencias="Mis sugerencias";
    public static String txt_info_peticion="Petición";
    public static String txt_info_queja="Queja";
    public static String txt_info_reclamo="Reclamo";
    public static String txt_info_sugerencia="Sugerencia";
    public static String txt_info_asunto="Asunto";
    public static String txt_info_nombre="Nombre";
    public static String txt_info_email="Correo electrónico";
    public static String txt_info_enviar_respuesta="Enviar respuesta";
    public static String txt_info_escribir_respuesta="Escribir respuesta";
    public static String txt_info_escribe_tu_respuesta="Escribe tu respuesta aquí...";
    public static String txt_info_usuario_soporte="Soporte";
    public static String txt_info_usuario="Usuario";

    /**
     * *******************************************************
     * URLS DE DESCARGAR DE INFORMACION (NO MODIFICAR)
     * ******************************************************
     */

    public static final String URL_DESCARGAR_NOTICIAS = "http://okonexion.com/upanel/public/app/descargar/noticias";
    public static final String URL_DESCARGAR_INSTITUCIONAL = "http://okonexion.com/upanel/public/app/descargar/institucional";
    public static final String URL_DESCARGAR_ENCUESTA_VIGENTE="http://okonexion.com/upanel/public/app/descargar/encuestas/vigente";
    public static final String URL_DESCARGAR_ENCUESTAS_ARCHIVADAS="http://okonexion.com/upanel/public/app/descargar/encuestas/archivadas";
    public static final String URL_ENVIAR_ENCUESTA_RESPUESTA="http://okonexion.com/upanel/public/app/enviar/encuestas/respuesta";
    public static final String URL_ENVIAR_PQR="http://okonexion.com/upanel/public/app/enviar/pqr";
    public static final String URL_RECIBIR_PQR="http://okonexion.com/upanel/public/app/recibir/pqr";

    /**
     * *******************************************************
     * VARIABLES DE CONTROL (NO MODIFICAR)
     * ******************************************************
     */

    //****NOTICIAS*****//
    public static boolean noticias_descargadas = false; //Indica si las noticias ya fueron descargadas
    public static int noticias_cantidad_a_cargar = 16;//Indica el numero de noticias a cargar
    public static int noticias_cargadas = 0;
    //****INSTITUCIONAL*****//
    public static boolean institucional_descargadas = false; //Indica si la informacion institucional ya fueron descargadas
    public static int institucional_cargadas = 0;
    //****ENCUESTAS*****//
    public static boolean encuestas_descargadas = false; //Indica si las encuesta archivadas ya fueron descargadas
    public static int encuestas_cantidad_a_cargar = 8;//Indica el numero de encuestas archivadas a cargar
    public static int encuestas_cargadas = 0;

    public static boolean descarga_iniciada = false;//Indica si existe un descarga iniciada


    /**
     * *******************************************************
     * VARIABLES DE DEFINCION DE DATOS (NO MODIFICAR)
     * ******************************************************
     */

    public static final String CONFIG_MOSTRAR_NOMBRE_SOLOTEXTO = "soloTexto";
    public static final String CONFIG_MOSTRAR_NOMBRE_TEXTOLOGO = "textoLogo";
    public static final String CONFIG_MOSTRAR_NOMBRE_SOLOLOGO = "soloLogo";
    public static final int W_IMAGEN_NOTICIA = 621;
    public static final int H_IMAGEN_NOTICIA = 483;
    public static final int FACTOR_ACERCAMIENTO_SCROLL = 15; //Indica el factor de acercamiento para cargar mas contenido al bajar el scroll

    public static int id_mensaje_no_hay_contenido = 7738283;
    public static int id_base_respuestas_encuesta=999929;



    /**
     * Establece la configuraciòn de apariencia dada por la configuracion de las variables de la App
     *
     * @param activity
     */
    public static void establecerBarraAccion(ActionBarActivity activity, String titulo) {


        //*************************************************************
        // BARRA DE ACCIÒN DEL A APLICACION***************************
        //*************************************************************

        //Establece el color de fondo de la barra App
        activity.getSupportActionBar().setBackgroundDrawable((new ComponenteInterfaz(activity)).crear_Gradient(GradientDrawable.Orientation.TOP_BOTTOM,App.colorBarraApp, Util.oscurecerColor(App.colorBarraApp,30)));
        //Establece el color del texto de la barra
        activity.getSupportActionBar().setTitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + App.nombreApp + "</font>"));

        /**NOTA: Alineación del texto y el logo de barra aun no soportado**/


        //Indica que mostrar en la barra de accion
        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_SOLOTEXTO) {
            activity.getSupportActionBar().setDisplayUseLogoEnabled(false);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
            if (titulo != null) {
                activity.getSupportActionBar().setSubtitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + titulo + "</font>"));
            }
        }

        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_TEXTOLOGO) {
            activity.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            activity.getSupportActionBar().setDisplayUseLogoEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(true);
            if (titulo != null) {
                activity.getSupportActionBar().setSubtitle(Html.fromHtml("<font color='" + App.colorNombreApp + "'>" + titulo + "</font>"));
            }
        }

        if (App.mostrarNombre == App.CONFIG_MOSTRAR_NOMBRE_SOLOLOGO) {
            activity.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            activity.getSupportActionBar().setDisplayUseLogoEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


    }

    /** Obtiene un String con el ID del dispotivo actual
     *
     * @param activity Actividad del contexto
     * @return Id
     */
    public static String obtenerIdDispositivo(Activity activity){
        String android_id = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }


}
