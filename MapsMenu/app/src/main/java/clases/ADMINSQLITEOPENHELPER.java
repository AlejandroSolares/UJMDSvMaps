package clases;

/**
 * Created by cesar on 20/4/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ADMINSQLITEOPENHELPER extends SQLiteOpenHelper {

    public ADMINSQLITEOPENHELPER(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);

    }
    @Override

    public void onCreate(SQLiteDatabase db) {

        //aquí creamos la tabla de usuario (dni, nombre, ciudad, numero)
        db.execSQL("CREATE TABLE " + CustomUbicaciones.table_name + " ("
                + CustomUbicaciones._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CustomUbicaciones.cod_ubicacion + " INTEGER NOT NULL,"
                + CustomUbicaciones.titulo_ubicacion + " TEXT NOT NULL,"
                + CustomUbicaciones.descripcion_ubicacion + " TEXT NOT NULL,"
                + CustomUbicaciones.latitud_ubicacion + " REAL NOT NULL,"
                + CustomUbicaciones.longitud_ubicacion + " REAL NOT NULL,"
                + "UNIQUE (" + CustomUbicaciones.cod_ubicacion + "))");

    }
    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists "+ CustomUbicaciones.table_name);

        db.execSQL("CREATE TABLE " + CustomUbicaciones.table_name + " ("
                + CustomUbicaciones._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CustomUbicaciones.cod_ubicacion + " INTEGER NOT NULL,"
                + CustomUbicaciones.titulo_ubicacion + " TEXT NOT NULL,"
                + CustomUbicaciones.descripcion_ubicacion + " TEXT NOT NULL,"
                + CustomUbicaciones.latitud_ubicacion + " REAL NOT NULL,"
                + CustomUbicaciones.longitud_ubicacion + " REAL NOT NULL,"
                + "UNIQUE (" + CustomUbicaciones.cod_ubicacion + "))");

    }


}