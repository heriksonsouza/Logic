package com.price.imc.herikson.imcprice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertaApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void chamarFormularioAluno(View view){
        Intent intent = new Intent(this, FormularioAluno.class);
        startActivity(intent);
    }

    public void informarUsuario(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sobre o aplicativo");

        builder.setMessage("Obrigado por utilizar o LOGICVAN. Este aplicativo vem para atender a necessidade de motoristas de transporte escolar que precisam" +
                " organizar as informaçoes necessárias para a fluidez do trabalho, como cadastro e relação de usuários do serviço oferecido.");//define a mensagem

        builder.setNegativeButton("VOLTAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertaApp = builder.create();//cria o AlertDialog
        alertaApp.show();//Exibe
    }
}
