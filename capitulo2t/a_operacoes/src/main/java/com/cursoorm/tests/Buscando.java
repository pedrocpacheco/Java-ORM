package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Buscando {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_orm");
        EntityManager em = factory.createEntityManager();

        Cliente clienteEncontrado = em.find(Cliente.class, 1);

        System.out.println(clienteEncontrado.toString());
    }
}
