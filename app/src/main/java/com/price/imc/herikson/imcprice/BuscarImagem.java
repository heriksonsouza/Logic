package com.price.imc.herikson.imcprice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by Herikson Souza on 11/04/18.
 */

public class BuscarImagem extends AsyncTask<String, Integer,Bitmap> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        //Buscar imagem na internet
        Bitmap imagem = null;
        try{
            URL url = new URL(strings[0]);
            imagem = BitmapFactory.decodeStream(url.openStream());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return imagem;
    }
}
