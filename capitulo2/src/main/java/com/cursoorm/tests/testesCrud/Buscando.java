package com.cursoorm.tests.testesCrud;

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

/*
 * 1- Criar Entity Manager
 *      - Crie uma EntityManagerFactory
 *      - Crie um EntityManager
 * 
 * 2- Encontrar um Objeto Especifico
 *      - Utilize o metodo find() do EntityManager instanciado
 *          - O primeiro parametro é o .class da Classe do Objeto
 *          - O segundo parametro é o ID do objeto especifico desejado
 */
