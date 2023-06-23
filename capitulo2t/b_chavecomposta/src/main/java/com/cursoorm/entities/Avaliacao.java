package com.cursoorm.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable{

    @Id
    @JoinColumn(name = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @Id
    @JoinColumn(name = "id_estabalecimento")
    @ManyToOne(optional = false)
    private Estabelecimento estabalecimento;

    @Column(name="vl_nota")
    private int nota;

    public Avaliacao(){

    }

    public Avaliacao(Usuario usuario, Estabelecimento estabalecimento, int nota) {
        this.usuario = usuario;
        this.estabalecimento = estabalecimento;
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estabelecimento getEstabalecimento() {
        return estabalecimento;
    }

    public void setEstabalecimento(Estabelecimento estabalecimento) {
        this.estabalecimento = estabalecimento;
    }

    public int getNota() {
        return nota;
    }



    public void setNota(int nota) {
        this.nota = nota;
    }
}

/*
 * 
 */