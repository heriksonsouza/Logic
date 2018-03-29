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

public class AdapterCarros extends BaseAdapter{

    Context contexto;
    List<Carro> carros;

    public AdapterCarros(Context contexto, List<Carro> carros) {
        this.contexto = contexto;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return carros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_carros, parent, false);
        ImageView imagemCarro = (ImageView) viewLinha.findViewById(R.id.imageViewCarro);
        TextView nomeCarro = (TextView) viewLinha.findViewById(R.id.textViewCarro);
        TextView modelo = (TextView) viewLinha.findViewById(R.id.textViewModelo);

        Carro carro = carros.get(position);
        imagemCarro.setImageResource(carro.getImagem());
        nomeCarro.setText(carro.getNome());
        modelo.setText(carro.getModelo());

        return viewLinha;
    }
}
