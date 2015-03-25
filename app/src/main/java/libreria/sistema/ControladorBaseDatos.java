package libreria.sistema;

/**
 * Created by Jhon on 24/03/2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ControladorBaseDatos extends SQLiteOpenHelper {

    String tablaConfig="CREATE TABLE config (id INTEGER AUTOINCREMET, opcion TEXT, valor TEXT)";


    public ControladorBaseDatos(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA QUE ALMACENA LA CONFIGURACION DE LA APLICACION
        db.execSQL(tablaConfig);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS config");
        db.execSQL(tablaConfig);
    }
}
