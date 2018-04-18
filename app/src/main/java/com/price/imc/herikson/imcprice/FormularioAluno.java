package com.price.imc.herikson.imcprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class FormularioAluno extends AppCompatActivity {

    EditText editNome;
    EditText editCpf;
    EditText editRg;
    EditText editEndereco;
    EditText editCep;
    EditText editTelefone;
    EditText editEmail;
    EditText editEscola;

    Aluno aluno = new Aluno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        editCpf = (EditText) findViewById(R.id.editTextCpf);
        editNome = (EditText) findViewById(R.id.editTextNome);
        editCep = (EditText) findViewById(R.id.editTextCep);
        editEmail = (EditText) findViewById(R.id.editTextEmail);
        editEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editRg = (EditText) findViewById(R.id.editTextRg);
        editTelefone = (EditText) findViewById(R.id.editTextFone);
        editEscola = (EditText) findViewById(R.id.editTextEscola);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null&bundle.containsKey("id")){
            aluno = new DAOAluno(this).buscarId(bundle.getLong("id"));
            editNome.setText(aluno.getNome());
            editCpf.setText(aluno.getCpf());
            editCep.setText(aluno.getCep());
            editEmail.setText(aluno.getEmail());
            editEndereco.setText(aluno.getEndereco());
            editRg.setText(aluno.getRg());
            editTelefone.setText(aluno.getTelefone());
            editEscola.setText(aluno.getEscola());
        }
    }

    public void salvarAluno(View view){

        aluno.setNome(editNome.getText().toString());
        aluno.setCep(editCep.getText().toString());
        aluno.setEmail(editEmail.getText().toString());
        DAOAluno dao = new DAOAluno(this);
        if(aluno.getId()==0){
            dao.inserirAluno(aluno);
        }else{
            dao.alterarAluno(aluno);
        }
        dao.inserirAluno(aluno);
        Log.i("Formulario", "Qtd" + dao.buscarTodos().size());
        finish();
    }
}
