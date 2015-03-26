package libreria.sistema;

/**
 * Created by Jhon on 24/03/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ControladorBaseDatos extends SQLiteOpenHelper {

    String tablaNoticias ="CREATE TABLE noticias (id INTEGER PRIMARY KEY AUTOINCREMENT, id_noticia INT, titulo TEXT, descripcion TEXT, imagen TEXT)";
    public static String nombreDB="db_okonexion";

    public ControladorBaseDatos(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA QUE ALMACENA LA CONFIGURACION DE LA APLICACION
        db.execSQL(tablaNoticias);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS noticias");
        db.execSQL(tablaNoticias);
    }


    public static boolean existeRegistro(SQLiteDatabase db, String NombreTabla, String columna, String valor){
        //Si hemos abierto correctamente la base de datos
            Cursor c = db.rawQuery("SELECT * FROM "+NombreTabla+" WHERE "+columna+"='"+valor+"'", null);
            //Nos aseguramos de que existe al menos un registro
            if (c.moveToFirst())
                return true;
            else
                return false;
    }
}
