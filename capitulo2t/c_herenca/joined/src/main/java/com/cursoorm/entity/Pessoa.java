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
@Inheritance(strategy = InheritanceType.JOINED)
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
 * Nesse tipo de herença, é criada uma tabela para a Classe Pai, com suas informações
 * E, para cada classe filha, é criada uma nova tabela, contendo apenas as suas informações.
 * 
 *      - Existe um relacionmento de 1-1 entre a Pai e as Filhas
 *      - Persistencia é feita na tabela pai e na tabela filha especifica
 *      - Não se usa @Table para as classes filhas
 *      - Não existe repetição de informação da pai nas filhas
 *  
 *      Problemas: 
 *          - Muitas consultas no banco de dados as vezes desnecessarias
 * 
 * Veja uma imagem de como é vista no banco de dados: 
 * 
 * 1- Na Classe Pai, coloque o @Inheritance(strategy = InheritanceType.JOINED)
 */