package com.price.imc.herikson.imcprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ApresentarImagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentar_imagem);

        BuscarImagem buscarImagem = new BuscarImagem(ApresentarImagem.this);
        buscarImagem.execute("https://www.fordofmurfreesboro.com/assets/stock/colormatched_02/white/640/cc_2017foc050002_02_640/cc_2017foc050002_02_640_g1.jpg");
    }
}
