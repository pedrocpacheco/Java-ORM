package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Buscando {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        Cliente clienteEncontrado = em.find(Cliente.class, 2);

        System.out.println(clienteEncontrado.getId() + " " + clienteEncontrado.getNome());

        em.close();
        fabrica.close();
    }
}
