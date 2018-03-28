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
        onDestroy();
    }
    public void chamarPrice(View view){
        Intent intent = new Intent(this, TelaPrice.class);
        startActivity(intent);
        onDestroy();
    }
}
