package com.price.imc.herikson.imcprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarImc(View view){
        Intent intent = new Intent(this, TelaImc.class);
        startActivity(intent);
    }
    public void chamarPrice(View view){
        Intent intent = new Intent(this, TelaPrice.class);
        startActivity(intent);
    }

    //CHAMAR SEGUNDA TELA
    public void chamarSegundaTela(View view){
        Intent intent = new Intent(this, SegundaTela.class);
        intent.putExtra("modeloMoto", "Iron883");
        intent.putExtra("quantidade", 3);
        startActivity(intent);
    }

    public void chamarApresentarImagem(View view){
        Intent intent = new Intent(this, ApresentarImagem.class);
        startActivity(intent);
    }

    public void chamarMostrarTimesWS(View view){
        Intent intent = new Intent(this, MostrarListaWS.class);
        startActivity(intent);
    }
}
