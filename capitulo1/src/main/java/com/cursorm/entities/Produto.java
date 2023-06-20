// 1- Primeira Classe feita

package com.cursorm.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id // Criando ID
    @SequenceGenerator(name="produto", sequenceName = "sq_tb_produto", allocationSize = 1) // Sequencia (ainda n sei)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto") // Gerando valor automaticamente usando sequence
    @Column(name = "id_produto")
    private int id;

    @Column(name="nm_produto", nullable = false, length = 20) // Muda o nome para padrão, não permite ser nulo, maximo de 10
    private String nome;

    @Column(name="vl_produto")
    private double preco;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_validade")
    private Calendar dataValidade;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "est_produto")
    private Estado estado;

    @CreationTimestamp
    @Column(name = "dt_cadastro")
    private Calendar dataCadastro;

    @UpdateTimestamp
    @Column(name = "dt_modificacao")
    private Calendar dataModificacao;

    @Formula("vl_preco*0.9")
    @Column(name = "vl_des_produto")
    private double precoDesconto;
}

/*
 * 1- Criamos o ID
 *      - Definimos que é um ID com o @Id
 *      - Criamos uma sequencia de nome produto, com valor de 1
 *      - Definimos um valor gerado automaticamente usando a sequencia
 * 
 * 2- Configuramos as Colunas com o @Column
 *      - Transformamos os nomes para os padrões de Banco de Dados (name = "tb_")
 *      - Definimos se o valor pode ou não ser nulo (nullable = false/true)
 *      - Definimos seu tamanho maximo (length = x)
 * 
 * 3- Configuramos a formatação do nosso campo Date/Calendar com @Temporal
 *      - Um Date ou Calendar num DB pode ter diversas formatações
 *      - Usando @Temporal(TemporalType.) podemos dizer o tipo de formatação desejado
 *      - Colocamos o DATE, assim, aparece so o dia do calendar
 * 
 * 4- Configuramos os Enums utilizando o @Enumerated
 *      - Originalmente, apareceria a valor numerico do enum (Primeiro = 0 | Segundo = 1)
 *      - Usando o @Enumerated(EnumType.) podemos dizer a formatação desejada
 *      - Colocamos o STRING, assim, aparecera o texto do valor do enum
 */