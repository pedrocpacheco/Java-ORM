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
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa{
    
    @Column(name = "nr_cnpj")
    private String cnpj;

}
