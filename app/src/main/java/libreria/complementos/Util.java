package libreria.complementos;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
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


    public static String oscurecerColor(String color,int cantidad){

        String rojo=color.substring(1,3);
        String verde=color.substring(3,5);
        String azul=color.substring(5,7);

        int intRojo=Util.convertirHexaDecimal(rojo);
        int intVerde=Util.convertirHexaDecimal(verde);
        int intAzul=Util.convertirHexaDecimal(azul);

//ahora verifico que no quede como negativo y resto
        if (intRojo - cantidad >= 0)
            intRojo = intRojo - cantidad;
        if (intVerde - cantidad >= 0)
            intVerde = intVerde - cantidad;
        if (intAzul - cantidad >= 0)
            intAzul = intAzul - cantidad;

        //voy a convertir a hexadecimal, lo que tengo en enteros
        rojo = Integer.toHexString(intRojo);
        verde = Integer.toHexString(intVerde);
        azul = Integer.toHexString(intAzul);

        //voy a validar que los string hexadecimales tengan dos caracteres
        if (rojo.length() < 2)
            rojo = "0" +rojo;
        if (verde.length() < 2)
            verde = "0"+verde;
        if (azul.length() < 2)
            azul = "0" +azul;

        String colorFinal="#"+rojo+verde+azul;
        return colorFinal;
    }

    public static int convertirHexaDecimal(String color){
       return Integer.parseInt(color, 16);
    }
}
