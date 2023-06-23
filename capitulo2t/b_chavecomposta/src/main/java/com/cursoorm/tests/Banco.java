package com.cursoorm.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Banco {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("chavecomposta");
        EntityManager em = factory.createEntityManager();
    }
}
