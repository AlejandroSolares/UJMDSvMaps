package com.example.cesar.mapsmenu;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import clases.ADMINSQLITEOPENHELPER;
import clases.Ubicaciones;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnLogin = (Button)findViewById(R.id.btnlogin);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        alta(getWindow().getDecorView().findViewById(android.R.id.content));




    }

    public void alta(View v) {
        //Listando lo que esta guardado en la "base de datos" RESTFUL
        ArrayList<Ubicaciones> lstub=  new ArrayList<Ubicaciones>();
        Ubicaciones ub = new Ubicaciones();
        lstub.add(new Ubicaciones(1,"Universdidad", "Esta es la Universidad Dr. Jose Matias Delgado", 13.6808129,-89.2548466 ));
        lstub.add(new Ubicaciones(2,"Otro Lugar", "Otro lugar descripcion",14.6808129,-89.2548466 ));

        //Definiendo variables para almacenar el output
        int cod_ubicacion = 0;
        LatLng cod_ubicacion_string;
        String titulo_ubicacion = "";
        String descripcion_ubicacion = "";
        double latitud_ubicacion = 0;
        double longitud_ubicaicion = 0;
        float zoom = 7;



        ADMINSQLITEOPENHELPER admin = new ADMINSQLITEOPENHELPER(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        //Mandar a llamar el restful para hacer la primera llamada de la información y almacenarla en SQLite

        //Leyendo la lista e insertando en la base de datos
        for (int indice = 0; indice < lstub.size();indice++)
        {
            cod_ubicacion = lstub.get(indice).getCod_ubicacion();
            titulo_ubicacion =  lstub.get(indice).getTitulo_ubicacion();
            descripcion_ubicacion = lstub.get(indice).getDescripcion_ubivacion();
            latitud_ubicacion = lstub.get(indice).getLatitud_ubicacion();
            longitud_ubicaicion = lstub.get(indice).getLongitud_ubicacion();
            cod_ubicacion_string = new LatLng(latitud_ubicacion,longitud_ubicaicion);
            ContentValues registro = new ContentValues();

            registro.put("cod_ubicacion", cod_ubicacion);
            registro.put("titulo_ubicacion", titulo_ubicacion);
            registro.put("descripcion_ubicacion", descripcion_ubicacion);
            registro.put("latitud_ubicacion", latitud_ubicacion);
            registro.put("longitud_ubicacion", longitud_ubicaicion);

            // los inserto en la base de datos
            try {
                bd.insert("ubicaciones", null, registro);
                    Toast.makeText(this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Problema al cargar los usuarios", Toast.LENGTH_SHORT).show();
            }
        }

        bd.close();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


       final  FragmentManager fm = getSupportFragmentManager();


        if (id == R.id.nav_inicio) {
            fm.beginTransaction().replace(R.id.contenedor, new InicioFragment()).commit();
        } else if (id == R.id.nav_map) {
            fm.beginTransaction().replace(R.id.contenedor, new MapFragment()).commit();
        } else if (id == R.id.nav_cuestionario) {

                fm.beginTransaction().replace(R.id.contenedor, new CuestionarioFragment()).commit();

        } else if (id == R.id.nav_examen) {
            fm.beginTransaction().replace(R.id.contenedor, new ExamenFragment()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.nav_iniciosesion){
            fm.beginTransaction().replace(R.id.contenedor, new LoginFragment()).commit();
        }
        else if (id == R.id.btnlogin)
        {
            fm.beginTransaction().replace(R.id.contenedor, new LoginFragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


