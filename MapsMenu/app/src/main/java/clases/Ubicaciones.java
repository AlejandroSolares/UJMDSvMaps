package clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by cesar on 14/4/2018.
 */
public class Ubicaciones {
    private int cod_ubicacion;
    private String titulo_ubicacion;
    private String descripcion_ubicacion;
    private double latitud_ubicacion;
    private double longitud_ubicacion;

    public Ubicaciones() {
    }

    public Ubicaciones(int cod_ubicacion, String titulo_ubicacion, String descripcion_ubivacion, double latitud_ubicacion, double longitud_ubicacion) {
        this.cod_ubicacion = cod_ubicacion;
        this.titulo_ubicacion = titulo_ubicacion;
        this.descripcion_ubicacion = descripcion_ubivacion;
        this.latitud_ubicacion = latitud_ubicacion;
        this.longitud_ubicacion = longitud_ubicacion;
    }

    public int getCod_ubicacion() {
        return cod_ubicacion;
    }

    public void setCod_ubicacion(int cod_ubicacion) {
        this.cod_ubicacion = cod_ubicacion;
    }

    public String getTitulo_ubicacion() {
        return titulo_ubicacion;
    }

    public void setTitulo_ubicacion(String titulo_ubicacion) {
        this.titulo_ubicacion = titulo_ubicacion;
    }

    public String getDescripcion_ubivacion() {
        return descripcion_ubicacion;
    }

    public void setDescripcion_ubivacion(String descripcion_ubivacion) {
        this.descripcion_ubicacion = descripcion_ubivacion;
    }

    public double getLatitud_ubicacion() {
        return latitud_ubicacion;
    }

    public void setLatitud_ubicacion(double latitud_ubicacion) {
        this.latitud_ubicacion = latitud_ubicacion;
    }

    public double getLongitud_ubicacion() {
        return longitud_ubicacion;
    }

    public void setLongitud_ubicacion(double longitud_ubicacion) {
        this.longitud_ubicacion = longitud_ubicacion;
    }

    @Override
    public String toString() {
        return "Ubicaciones{" +
                "cod_ubicacion=" + cod_ubicacion +
                ", titulo_ubicacion='" + titulo_ubicacion + '\'' +
                ", descripcion_ubivacion='" + descripcion_ubicacion + '\'' +
                ", latitud_ubicacion=" + latitud_ubicacion +
                ", longitud_ubicacion=" + longitud_ubicacion +
                '}';
    }
   
}