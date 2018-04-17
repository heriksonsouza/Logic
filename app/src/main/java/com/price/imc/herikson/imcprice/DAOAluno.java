package com.price.imc.herikson.imcprice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class DAOAluno {

    SQLiteDatabase db;

    public DAOAluno(Context context){
        db = new BDCore(context).getWritableDatabase();
    }

    public void inserirAluno(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("rg", aluno.getRg());
        values.put("endereco", aluno.getEndereco());
        values.put("telefone", aluno.getTelefone());
        values.put("escola", aluno.getEscola());
        values.put("email", aluno.getEmail());
        values.put("cep", aluno.getCep());
        db.insert("aluno", null, values);
    }

    public void alterarAluno(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("rg", aluno.getRg());
        values.put("endereco", aluno.getEndereco());
        values.put("telefone", aluno.getTelefone());
        values.put("escola", aluno.getEscola());
        values.put("email", aluno.getEmail());
        values.put("cep", aluno.getCep());
        db.update("carro", values, "id="+aluno.getId(), null);
    }

    public void excluirCarro(Carro carro){
        db.delete("carro", "id="+carro.getId(), null);
    }

    public List<Aluno> buscarTodos(){
        List<Aluno> alunos = new ArrayList<>();
        String[] colunas = {"id", "nome", "cpf", "rg", "endereco", "telefone", "escola", "email", "cep"};
        Cursor cursor = db.query("aluno", colunas, null, null, null, null, null);
        cursor.moveToFirst();

        for (int x=0; x<cursor.getCount(); x++){
            Aluno aluno= new Aluno();
            aluno.setId(cursor.getLong(0));
            aluno.setNome(cursor.getString(1));
            aluno.setCpf(cursor.getString(2));
            aluno.setRg(cursor.getString(3));
            aluno.setEndereco(cursor.getString(4));
            aluno.setTelefone(cursor.getString(5));
            aluno.setEscola(cursor.getString(6));
            aluno.setEmail(cursor.getString(7));
            aluno.setCep(cursor.getString(8));

            alunos.add(aluno);
            cursor.moveToNext();
        }

        return alunos;
    }

    public Aluno buscarId(Long id){
        String[] colunas = {"id", "nome", "cpf", "rg", "endereco", "telefone", "escola", "email", "cep"};
        Cursor cursor = db.query("aluno", colunas, null, null, null, null, null);
        cursor.moveToFirst();
       Aluno aluno = new Aluno();
        if(cursor.getCount()>0){
            aluno.setId(cursor.getLong(0));
            aluno.setNome(cursor.getString(1));
            aluno.setCpf(cursor.getString(2));
            aluno.setRg(cursor.getString(3));
            aluno.setEndereco(cursor.getString(4));
            aluno.setTelefone(cursor.getString(5));
            aluno.setEscola(cursor.getString(6));
            aluno.setEmail(cursor.getString(7));
            aluno.setCep(cursor.getString(8));
        }
        return aluno;
    }
}

