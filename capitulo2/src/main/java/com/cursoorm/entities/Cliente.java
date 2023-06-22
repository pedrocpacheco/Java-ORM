package com.cursoorm.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "sq_tb_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente")
    @Column(name = "id_cliente")
    private int id;

    @Column(name = "nm_cliente")
    private String nome;

    @ManyToMany(mappedBy = "clientes")
    private List<Estabelecimento> estabelecimentos;

    public Cliente() {
    }

    public Cliente(int id, String nome, List<Estabelecimento> estabelecimentos) {
        this.id = id;
        this.nome = nome;
        this.estabelecimentos = estabelecimentos;
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

    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", estabelecimentos=" + estabelecimentos + "]";
    }
}
