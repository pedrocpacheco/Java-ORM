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
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica extends Pessoa{
 
    @Column(name = "nr_cnpj")
    private String cpnj;

}
