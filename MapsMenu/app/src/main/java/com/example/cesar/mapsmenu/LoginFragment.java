package com.example.cesar.mapsmenu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import clases.Session;
import clases.Ubicaciones;
import clases.Usuarios;


public class LoginFragment extends Fragment {

    private EditText txtuser;
    private EditText txtpass;
    private Button btnlogin;
    private Button btnMenuPrincipal;
    SharedPreferences sp;
    Session session;

    ArrayList<Usuarios> lstus=  new ArrayList<Usuarios>();
    Usuarios us = new Usuarios();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);

        lstus.add(new Usuarios(1,"cesar","cesar"));
        lstus.add(new Usuarios(1,"alejandro","solares"));

        //Validando Login
        //Asignando valores ingresados
        btnMenuPrincipal = (Button) rootView.findViewById(R.id.btnMenuPpal);
        btnlogin = (Button) rootView.findViewById(R.id.btnIngresar);

        session = new Session(getActivity());

        Toast.makeText(getActivity(),"Bienvenido a Inicio de sesion",Toast.LENGTH_SHORT).show();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Capturando datos ingresados
                Boolean login = false;
                txtuser = (EditText) rootView.findViewById(R.id.txtuser);

                txtpass = (EditText) rootView.findViewById(R.id.txtpwd);

                String struser = txtuser.getText().toString();
                String strpass = txtpass.getText().toString();

                if(struser.equals("") || strpass.equals(""))
                {
                    Toast.makeText(getActivity(),"Por favor ingrese un usuario o contraseño",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    for(int i = 0; i<lstus.size();i++) {
                        if (struser.equals(lstus.get(i).getUsuario().toString()) && strpass.equals(lstus.get(i).getPassword().toString())) {

                            login = true;

                        }
                    }

                    if (login == true)
                    {
                        session.createUserLoginSession(struser,
                                strpass);
                        Toast.makeText(getActivity(), "Bienvenido", Toast.LENGTH_SHORT).show();
                        Fragment fragment = new InicioFragment();

                        FragmentManager fragmentManager = getFragmentManager();

                        fragmentManager.beginTransaction().replace(R.id.contenedor, fragment).commit();

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Ingrese correctamente su usuario o contraseña", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment fragment = new InicioFragment();

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.contenedor, fragment).commit();
            }
        });





        return rootView;

    }


}
