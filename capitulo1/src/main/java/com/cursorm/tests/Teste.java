package com.cursorm.tests;

import jakarta.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("cursoorm").createEntityManager();
    }
}
