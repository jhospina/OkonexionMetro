package libreria.complementos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Display;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
     * @return (JSONObject) Obtiene un JSON con los datos
     */
    public static JSONObject conectar(String url) {

        InputStream is = null;
        String result = "";
        JSONObject json = null;
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
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

        Log.e("RESULT",result);

        return json;
    }



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
}
