package com.cursoorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa{
    
    @Column(name = "nr_cpf")
    private String cpf;

}
