package com.price.imc.herikson.imcprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class FormularioCarro extends AppCompatActivity {

    EditText editNome;
    EditText editModelo;
    Carro carro = new Carro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carro);
        editNome = (EditText) findViewById(R.id.editNome);
        editModelo = (EditText) findViewById(R.id.editModelo);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null&bundle.containsKey("id")){
            carro = new DAOCarro(this).buscarId(bundle.getLong("id"));
            editNome.setText(carro.getNome());
            editModelo.setText(carro.getModelo());
        }
    }

    public void salvarCarro(View view){
        //Carro carro = new Carro();
        carro.setNome(editNome.getText().toString());
        carro.setModelo(editModelo.getText().toString());
        DAOCarro dao = new DAOCarro(this);
        if(carro.getId()==0){
            dao.inserirCarro(carro);
        }else{
            dao.alterarCarro(carro);
        }
        dao.inserirCarro(carro);
        Log.i("Formulario", "Qtd" + dao.buscarTodos().size());
        finish();
    }

    }
