package com.cursoorm.tests.testesRelacoes;

import com.cursoorm.entities.Livro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestLivro {
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojaorm");
        EntityManager em = factory.createEntityManager();

        Livro livro = new Livro();
        livro.setIsbn(123);
        livro.setTitulo("Pedro");

        em.persist(livro);
        
        System.out.println("Persistiu");

    }
}
