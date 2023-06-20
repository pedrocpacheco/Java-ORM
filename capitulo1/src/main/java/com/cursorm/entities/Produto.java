// 1- Primeira Classe feita

package com.cursorm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
    
    @Id // Criando ID
    @SequenceGenerator(name="produto", sequenceName = "sq_tb_produto", allocationSize = 1) // Sequencia (ainda n sei)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto") // Gerando valor automaticamente usando sequence
    private int id;

}
