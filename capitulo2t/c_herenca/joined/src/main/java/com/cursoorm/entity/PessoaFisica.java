package com.cursoorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa{
    
    @Column(name = "nr_cpf")
    private String cpf;

}

/*
 * Ainda é necessario colocar como entity
 */
