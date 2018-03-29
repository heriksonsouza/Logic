package com.price.imc.herikson.imcprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SegundaTela extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listViewCarros;

    private final String TAG="Segunda tela";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        listViewCarros = (ListView) findViewById(R.id.listCarros);

        String times[] = {"Camaro", "Civic", "Corolla"};
        ArrayAdapter<String> adapterCarros = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times);

        listViewCarros.setAdapter(adapterCarros);
        listViewCarros.setOnItemClickListener(this);

        //-------------------------------------------------------------------------------
        Bundle bundle = getIntent().getExtras();
        String modelo = bundle.getString("modeloMoto");
        Integer quantidade = bundle.getInt("quantidade");
        Log.i("Segunda tela", "Modelo da moto: "+modelo);
        Log.i("Segunda tela", "Quantidade no estoque: "+quantidade);
        //-------------------------------------------------------------------------------

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("SegundaTela", parent.getItemAtPosition(position).toString());
    }
}
