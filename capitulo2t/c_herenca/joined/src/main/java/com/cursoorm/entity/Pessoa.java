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
 * Nesse tipo de herença, a representação no Banco de Dados é a mais comum
 * Veja uma imagem de como é vista no banco de dados: 
 * 
 * 1- Na Classe Pai, coloque o @Inheritance(strategy = InheritanceType.JOINED)
 * 
 * Explicação do proprio Java:
 * Uma estratégia na qual os campos específicos de uma subclasse são mapeados para uma tabela separada dos campos 
 * comuns à classe pai e uma junção é executada para instanciar a subclasse.
 */