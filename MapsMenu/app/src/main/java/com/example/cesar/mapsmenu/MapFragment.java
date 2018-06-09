package com.example.cesar.mapsmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import clases.Ubicaciones;


public class MapFragment extends SupportMapFragment implements OnMapReadyCallback{
    ArrayList<Ubicaciones> lstub=  new ArrayList<Ubicaciones>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Ubicaciones ub = new Ubicaciones();
        lstub.add(new Ubicaciones(1,"Universdidad", "Esta es la Universidad Dr. Jose Matias Delgado", 13.6808129,-89.2548466 ));
        lstub.add(new Ubicaciones(2,"Parque de la familia", " Parque de La Familia 7A Avenida Norte La Unión El Salvador",13.338472,-87.839985 ));
        lstub.add(new Ubicaciones(2,"Volcan de San Vicente", "Volcan de San Vicente, SAN VICENTE",13.596604,-88.837509 ));
        // Add a marker in Sydney and move the camera

        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Posicionar el mapa en una localización y con un nivel de zoom

        CargarData(map);
        float zoom = 13;
    }

    public void CargarData(GoogleMap map)
    {
        for (int indice = 0; indice < lstub.size();indice++)
        {
            int cod_ubicacion = 0;
            LatLng cod_ubicacion_string;
            String titulo_ubicacion = "";
            String descripcion_ubicacion = "";
            double latitud_ubicacion = 0;
            double longitud_ubicaicion = 0;
            float zoom = 7;
            cod_ubicacion = lstub.get(indice).getCod_ubicacion();
            titulo_ubicacion =  lstub.get(indice).getTitulo_ubicacion();
            descripcion_ubicacion = lstub.get(indice).getDescripcion_ubivacion();
            latitud_ubicacion = lstub.get(indice).getLatitud_ubicacion();
            longitud_ubicaicion = lstub.get(indice).getLongitud_ubicacion();

            cod_ubicacion_string = new LatLng(latitud_ubicacion,longitud_ubicaicion);
            map.addMarker(new MarkerOptions()
                    .title(titulo_ubicacion)
                    .snippet(descripcion_ubicacion)
                    .position(cod_ubicacion_string));

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(cod_ubicacion_string,zoom));

        }

    }



}
