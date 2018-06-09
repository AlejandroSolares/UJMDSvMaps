package com.example.cesar.mapsmenu;

import android.provider.BaseColumns;

/**
 * Created by cesar on 14/4/2018.
 */

public abstract class CustomUbicaciones implements BaseColumns {

    public static final String TABLE_NAME ="ubicaciones";
    public static final String cod_ubicacion = "cod_ubicacion";
    public static final String  titulo_ubicacion = "titulo_ubicacion";
    public static final String descripcion_ubicacion = "descripcion_ubicacion";
    public static final String latitud_ubicacion = "latitud_ubicacion";
    public static final String longitud_ubicacion = "longitud_ubicacion";

}
