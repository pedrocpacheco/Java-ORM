package com.cursoorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PessoaFisica extends Pessoa{
    
    @Column(name = "nr_cpf")
    private String cpf;

}

/*
 * Utiliza-se o @Entity
 * Não pode utilizar o @Table
 */
