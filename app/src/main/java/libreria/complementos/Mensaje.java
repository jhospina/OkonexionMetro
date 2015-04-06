package libreria.complementos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Jhon on 25/03/2015.
 */
public class Mensaje {


    public static void alerta(Activity activity, String titulo, String mensaje) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle(titulo)
                .setIcon(activity.getResources().getDrawable(android.R.drawable.ic_dialog_info))
                .setMessage(mensaje);

        builder.setNeutralButton("Aceptar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();           }
        });

        builder.show();
    }


    public static void toast(Activity activity,String texto){
        Toast toast =
                Toast.makeText(activity,
                        texto, Toast.LENGTH_LONG);
        toast.show();
    }

}
