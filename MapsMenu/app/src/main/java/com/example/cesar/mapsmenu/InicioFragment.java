package com.example.cesar.mapsmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import clases.Session;


public class InicioFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_inicio, container, false);

      // Inflate the layout for this fragment
        Session session;
        Boolean IsLogedon;


        session = new Session(getActivity());

        IsLogedon = session.checkLogin();


        if (IsLogedon)
        {
            Toast.makeText(getActivity(),"Esta logueado",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getActivity(), "No esta logueado", Toast.LENGTH_SHORT).show();

        }
return rootView;
    }
}
