package com.price.imc.herikson.imcprice;

/**
 * Created by Herikson Souza on 28/03/18.
 */

public class Carro {

    private long id;
    private String nome;
    private String modelo;
    private int imagem;

    public Carro(){

    }

    public Carro(long id, String nome, String modelo, int imagem) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.imagem = imagem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
