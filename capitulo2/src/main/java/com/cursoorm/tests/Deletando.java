package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Deletando {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        Cliente clienteBuscado = em.find(Cliente.class, 2);

        em.remove(clienteBuscado);
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    }
}
