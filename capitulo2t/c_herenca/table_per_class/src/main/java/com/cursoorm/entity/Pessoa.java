package com.cursoorm.entity;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa {
    
    @Id
    @SequenceGenerator(name ="pessoa", sequenceName = "sq_tb_pessoa", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pessoa")
    @Column(name = "id_pessoa")
    private int id;

    @Column(name = "nm_pessoa", length = 50, nullable = false)
    private String nome;

}

/*
 * Nesse tipo de herença, são criadas tabelas para tanta a Classe Pai e suas filhas.
 * Aqui, as filhas também contem em sua tabela, as informações da classe pai.
 * 
 *      - Não existe relacionamento entre as tabelas no banco de dados
 *      - Persistencia pode ser feita individualmente em qualquer tabela
 *      - Pode utilizar a @Table para mudar o nome das tabelas das filhas
 *      - Consultas são mais otimizadas, pois pode ser feita em uma filha direto
 * 
 *      Problema: 
 *          - Repete informações em colunas diferentes
 * 
 * 1- Na Classe Pai, coloque o @Inheritance(strategy = InheritanceType.JOINED)
 */
