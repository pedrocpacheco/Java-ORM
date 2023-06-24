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
@Table(name = "tb_cliente")
public class Cliente {
    
    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "sq_tb_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente")
    @Column(name = "id_cliente")
    private int id;
    
    @Column(name = "nm_cliente", nullable = false, length = 50)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_cadastro")
    private Calendar dataCadastro;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_atualizacao")
    private Calendar dataAtualizacao;

}

/*
 * Entidade mapeada com JPA utilizando todas as Annotations aprendidas
 */