package com.example.cesar.mapsmenu;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.graphics.Bitmap;

import java.io.InputStream;

import clases.ImagenesOnline;



public class ExamenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //final View rootView = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        return inflater.inflate(R.layout.fragment_examen, container, false);

        //new DownloadImageTask((ImageView)  rootView.findViewById(R.id.ivProfile)).execute(getString(R.string.Direccion));
        //new ImagenesOnline(getContext(), (ImageView)rootView.findViewById(R.id.ivProfile),"http://icons.iconarchive.com/icons/iconshock/world-of-warcraft/256/warcraft-2-icon.png");
    }

}

/*
class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}*/