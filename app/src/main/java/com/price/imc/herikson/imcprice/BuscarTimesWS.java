package com.price.imc.herikson.imcprice;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by aluno on 11/04/18.
 */

public class BuscarTimesWS extends AsyncTask<String, Integer, String> {

    Activity activity;
    ProgressBar progressBar;

    public BuscarTimesWS(Activity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar = (ProgressBar) activity.findViewById(R.id.progressTime);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        List<Carro> carros = gson.fromJson(s, new TypeToken<List<Carro>>(){}.getType());
        AdapterCarros adapterCarros = new AdapterCarros(activity, carros);
        ListView listView = (ListView) activity.findViewById(R.id.listTimes);
        listView.setAdapter(adapterCarros);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        String jSonRetorno=null;
        try{
            URL url = new URL(strings[0]);
            InputStream stream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String linha="";
            while ((linha = bufferedReader.readLine())!=null){
                builder.append(linha);
            }
            jSonRetorno=builder.toString();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return jSonRetorno;
    }
}
