package libreria.complementos;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

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
