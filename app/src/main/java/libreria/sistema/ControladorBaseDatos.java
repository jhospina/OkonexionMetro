package libreria.sistema;

/**
 * Created by Jhon on 24/03/2015.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ControladorBaseDatos extends SQLiteOpenHelper {

    public static String nombreDB="db_okonexion";
    public static String tabla_noticias="noticias";
    public static String tabla_institucional="institucional";

    String tablaNoticias ="CREATE TABLE "+ControladorBaseDatos.tabla_noticias+" (id INTEGER PRIMARY KEY AUTOINCREMENT, id_noticia INT, titulo TEXT, descripcion TEXT, imagen TEXT,fecha TEXT)";
    String tablaInstitucional="CREATE TABLE "+ControladorBaseDatos.tabla_institucional+" (id INTEGER PRIMARY KEY AUTOINCREMENT, id_institucional INT, titulo TEXT, descripcion TEXT,fecha TEXT)";

    public ControladorBaseDatos(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaNoticias);
        db.execSQL(tablaInstitucional);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS "+ControladorBaseDatos.tabla_noticias);
        db.execSQL(tablaNoticias);
        db.execSQL("DROP TABLE IF EXISTS "+ControladorBaseDatos.tabla_institucional);
        db.execSQL(tablaInstitucional);
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

    public static void vaciarTabla(SQLiteDatabase db, String NombreTabla){
        db.execSQL("DELETE FROM "+NombreTabla);
    }


}
