package com.cursoorm.entity;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {
    
    @Id
    @SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estabelecimento")
    @Column(name = "id_estabelecimento")
    private int id;

    @Column(name = "nm_estabelecimento", nullable = false, length = 50)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_criacao")
    private Calendar dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_atualizacao")
    private Calendar dataAtualizacao;

}
