package libreria.complementos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jhon on 24/03/2015.
 */
public class Util {

    /** Retorna el tamaño de la pantalla
     *
     * @param contexto (Activity) La actividad actual en pantalla
     * @return (Point) Las propiedades de la pantalla
     */
    public static Point obtenerTamanoPantalla(Activity contexto){
        Display display = contexto.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return size;
    }


    /**
     * Se conecta a la URL de un servidor indicado y obtiene un JSON con los datos de respuesta
     *
     * @param url (String) URL de la conexcion
     * @param datosEnviar (String[][]) Un array dos dimensiones con los datos a enviar
     * @return (JSONObject) Obtiene un JSON con los datos
     */
    public static JSONObject conectar(String url,String[][] datosEnviar) {

        InputStream is = null;
        String result = "";
        JSONObject json = null;
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);

            if(datosEnviar!=null) {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                for(int i=0;i<datosEnviar.length;i++){
                    params.add(new BasicNameValuePair(datosEnviar[i][0], datosEnviar[i][1]));
                }
                httppost.setEntity(new UrlEncodedFormEntity(params));
            }

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        }catch(Exception e){}

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            is.close();
            result=sb.toString();
        } catch(Exception e){}

        try{
            json = new JSONObject(result);
        }catch(JSONException e){}

        return json;
    }



    public static Bitmap descargarImagen(String imageHttpAddress){
        URL imageUrl = null;
        Bitmap imagen = null;
        try{
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }



    /** Verifica la conexion de internet de la aplicacion
     *
     * @param ctx La Actividad actual
     * @return
     */
    public static boolean verificarConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }


    public static String recortarTexto(String texto,int longitud){
        String texto_final="";

        String[] desc=texto.split(" ");

        for(int i=0;i<desc.length;i++){
            texto_final+=desc[i]+" ";
            if(texto_final.length()>longitud)
                break;;
        }
        return texto_final.substring(0,texto_final.length()-1);
    }
}
