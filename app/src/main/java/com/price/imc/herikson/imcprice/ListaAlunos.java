package com.price.imc.herikson.imcprice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunos extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private ListView listViewAlunos;

    private final String TAG="Segunda tela";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listViewAlunos = (ListView) findViewById(R.id.listCarros);

        String times[] = {"Camaro", "Civic", "Corolla"};
        ArrayAdapter<String> adapterCarros = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times);

        //LINHA 2
        //LINHA 3

        /*
        Bundle bundle = getIntent().getExtras();
        String modelo = bundle.getString("modeloMoto");
        Integer quantidade = bundle.getInt("quantidade");
        Log.i("Segunda tela", "Modelo da moto: "+modelo);
        Log.i("Segunda tela", "Quantidade no estoque: "+quantidade);
        */

    }

    public void chamarFormularioAluno(View view){
        Intent intent = new Intent(this, FormularioAluno.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        preencherLista();
    }

    public void preencherLista(){
        //Novo Adapter
        List<Aluno> listaAlunos = new ArrayList<>();
        //Linha 1
        listaAlunos = new DAOAluno(this).buscarTodos();
        AdapterAlunos adapter = new AdapterAlunos(this, listaAlunos);
        listViewAlunos.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("FormularioAlunos", parent.getItemAtPosition(position).toString());
        //pegar objeto a partir da posicao no listview
        Aluno aluno = (Aluno) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, FormularioAluno.class);
        intent.putExtra("id", aluno.getId());
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("MainActivity", parent.getItemAtPosition(position).toString());
        final Aluno aluno = (Aluno) parent.getItemAtPosition(position);
        final DAOAluno dao = new DAOAluno(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja remover o aluno?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dao.excluirAluno(aluno);
                        preencherLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        builder.show();
        return true;
    }
}


//Linha1: listaCarros.add(new Carro(1L, "Camaro", "3.0-SS", R.drawable.amarelo));
//Linha2: listViewCarros.setAdapter(adapterCarros);
//Linha3: listViewCarros.setOnItemClickListener(this);
//Linha 4: Busca as preferências de outra Activity (deve-se passar o nome da Activity):
// SharedPreferences spg = this.getSharedPreferences("MainActivity", Context.MODE_PRIVATE);