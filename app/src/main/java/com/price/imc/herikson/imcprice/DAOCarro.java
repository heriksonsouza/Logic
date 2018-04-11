package com.price.imc.herikson.imcprice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herikson Souza on 09/04/18.
 */

public class DAOCarro {

    SQLiteDatabase db;

    public DAOCarro(Context context){
    db = new BDCore(context).getWritableDatabase();
        }

    public void inserirCarro(Carro carro){
        ContentValues values = new ContentValues();
        values.put("nome", carro.getNome());
        values.put("modelo", carro.getModelo());
        db.insert("carro", null, values);
    }

    public void alterarCarro(Carro carro){
        ContentValues values = new ContentValues();
        values.put("nome", carro.getNome());
        values.put("modelo", carro.getModelo());
        //db.update("carro", values, "id=?", new String[]{String.valueOf(carro.getId())});
        db.update("carro", values, "id="+carro.getId(), null);
    }

    public void excluirCarro(Carro carro){
        db.delete("carro", "id="+carro.getId(), null);
    }

    public List<Carro> buscarTodos(){
        List<Carro> carros = new ArrayList<>();
        String[] colunas = {"id", "nome", "modelo"};
        Cursor cursor = db.query("carro", colunas, null, null, null, null, null);
        cursor.moveToFirst();

        for (int x=0; x<cursor.getCount(); x++){
            Carro carro = new Carro();
            carro.setId(cursor.getLong(0));
            carro.setNome(cursor.getString(1));
            carro.setModelo(cursor.getString(2));
            carros.add(carro);
            cursor.moveToNext();
        }

        return carros;
    }

    public Carro buscarId(Long id){
        String[] colunas = {"id", "nome", "modelo"};
        Cursor cursor = db.query("carro", colunas, "id="+id, null, null, null, null);
        cursor.moveToFirst();
        Carro carro = new Carro();
        if(cursor.getCount()>0){
            carro.setId(cursor.getLong(0));
            carro.setNome(cursor.getString(1));
            carro.setModelo(cursor.getString(2));
        }
        return carro;
    }
}
