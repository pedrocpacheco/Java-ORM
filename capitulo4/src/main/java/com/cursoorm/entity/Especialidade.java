package com.cursoorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_especialidade")
public class Especialidade {

    @Id
    @SequenceGenerator(name = "especialidade", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "especialidade")
    @Column(name = "id_especialidade")
    private int id;

    @Column(name = "nm_especialidade", nullable = false, length = 40)
    private String nome;
    
}
