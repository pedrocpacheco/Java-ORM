package com.cursorm.entities;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {
    
    @Id
    @SequenceGenerator(name="fornecedor", sequenceName="sq_tb_fornecedor", allocationSize=1) // Muda de quanto em quanto vai
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fornecedor")
    @Column(name = "id_fornecedor")
    private int id;

    @Column(name = "nm_fornecedor", nullable = false, length = 50)
    private String nome;

    @CreationTimestamp
    @Column(name="dt_cadastro")
    private Calendar dataCadastro;

    @UpdateTimestamp
    @Column(name="dt_modificacao")
    private Calendar dataModificacao;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nome, Calendar dataCadastro, Calendar dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
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

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
