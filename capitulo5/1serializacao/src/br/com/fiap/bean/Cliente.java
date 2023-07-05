package br.com.fiap.bean;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private int id;

    private String nome;

    private Endereco endereco; // Precisa ser serializado tbm

    public Cliente(){

    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    

}
