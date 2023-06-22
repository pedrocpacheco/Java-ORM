package com.cursoorm.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteGerenciador {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        fabrica.close();
    }
}

/*
 * 1- Quando queremos criar entidades no nosso banco:
 *      - Precisamos EntityManagerFactory, que é uma Fabrica que criara as entitymanagers, passando o nome da nossa
 *        unidade de persistencia definida no pom.xml 
 *      - Com a fabrica criada, criamos o Entoty Manager que desejamos.
 */
