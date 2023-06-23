package com.cursoorm.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_contrato")
public class ContratoAluguel {
    
    @Id
    @SequenceGenerator(name = "contrato", sequenceName = "sq_tb_contrato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "contrato")
    @Column(name = "id_contrato")
    private int id;

    @Column(name = "vl_aluguel")
    private float valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_vencimento_aluguel")
    private Calendar dataVencimento;

    @OneToOne
    @JoinColumn(name = "id_estabelecimento")
    private Estabelecimento estabelecimento;

    public ContratoAluguel(){

    }

    public ContratoAluguel(int id, float valor, Calendar dataVencimento, Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.estabelecimento = estabelecimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

   
}
