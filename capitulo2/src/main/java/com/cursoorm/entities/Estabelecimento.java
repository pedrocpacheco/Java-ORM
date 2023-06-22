package com.cursoorm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estabelecimento")
    @Column(name = "id_estabelecimento")
    private Integer id;

    @Column(name = "nm_estabelecimento", length = 50)
    private String nome;    

    @OneToOne(mappedBy = "estabelecimento") // Bi relacionamento (ja foi feito em outra classe)
    private ContratoAluguel contrato;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoEstabelecimento tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estabelecimento [id=" + id + ", nome=" + nome + "]";
    }

}
