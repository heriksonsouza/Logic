package com.price.imc.herikson.imcprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SegundaTela extends AppCompatActivity {

    private final String TAG="Segunda tela";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Bundle bundle = getIntent().getExtras();
        String modelo = bundle.getString("modeloMoto");
        Integer quantidade = bundle.getInt("quantidade");
        Log.i("Segunda tela", "Modelo da moto: "+modelo);
        Log.i("Segunda tela", "Quantidade no estoque: "+quantidade);
    }
}
