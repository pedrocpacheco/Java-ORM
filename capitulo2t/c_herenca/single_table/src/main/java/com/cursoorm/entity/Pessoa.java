package com.cursoorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Pessoa {
    
    @Id
    @SequenceGenerator(name = "pessoa", sequenceName = "sq_tb_pessoa", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pessoa")
    @Column(name = "id_pessoa")
    private int id;

    @Column(name = "nm_pessoa", length = 50, nullable = false)
    private String nome;

}

/*
 * Neste tipo de herança, é criada apenas 1 tabela, contendo o nome da Classe pai. Nela estão presentes
 * tanto a informação da Pai, quanto as de todas as filhas. O que os diferencia, é a Discriminator Column.
 * 
 *      - Todas as informações presentes em só uma tabela
 *      - As classes filhas não devem usar o @Table
 *      - As Classes filhas podem mudar o seu valor no banco com o @DiscriminatorValue
 *  
 *      Problemas: 
 *          - Sempre haveram campos em branco. Pois uma PF não tem CNPJ
 *          - Os valores das classes filhas não podem ser obrigatorios por isso
 * 
 * Veja uma imagem de como é vista no banco de dados: 
 * 
 * 1- Na Classe Pai, coloque o @Inheritance(strategy = InheritanceType.SEQUENCE_TABLE) ou deixe sem nada
 */