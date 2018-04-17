package com.price.imc.herikson.imcprice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Herikson Souza on 28/03/18.
 */

public class AdapterAlunos extends BaseAdapter{

    Context contexto;
    List<Aluno> alunos;

    public AdapterAlunos(Context contexto, List<Aluno> alunos) {
        this.contexto = contexto;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_alunos, parent, false);
        TextView nome = (TextView) viewLinha.findViewById(R.id.textViewNome);
        TextView endereco = (TextView) viewLinha.findViewById(R.id.textViewEndereco);
        TextView escola = (TextView) viewLinha.findViewById(R.id.textViewEscola);

        Aluno aluno = alunos.get(position);
        nome.setText(aluno.getNome());
        endereco.setText(aluno.getEndereco());
        escola.setText(aluno.getEscola());
        return viewLinha;
    }
}
