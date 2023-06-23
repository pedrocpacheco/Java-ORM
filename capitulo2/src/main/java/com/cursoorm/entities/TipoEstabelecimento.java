package com.cursoorm.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_estabelecimento")
public class TipoEstabelecimento {
    
    @Id
    @SequenceGenerator(name="tipoEstabelecimento", sequenceName = "sq_tb_tipo_estabelecimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoEstabelecimento")
    @Column(name = "id_tipo")
    private int id;

    @Column(name = "nm_tipo", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "tipo") // Se termina com Many -> Coleção
    private List<Estabelecimento> estabelecimentos;

    public TipoEstabelecimento(){
        
    }

    public TipoEstabelecimento(int id, String nome, List<Estabelecimento> estabelecimentos) {
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
}
