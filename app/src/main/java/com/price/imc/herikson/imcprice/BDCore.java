package com.price.imc.herikson.imcprice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class BDCore extends SQLiteOpenHelper {
    private static final String NOME="aula";
    private static final int VERSAO= 1;

    public BDCore(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table aluno(id integer primary key autoincrement, nome varchar(100), modelo varchar(100));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table aluno");
    onCreate(db);
    }
}
