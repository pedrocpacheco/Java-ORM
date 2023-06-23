package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Adicionando {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_orm");
        EntityManager em = factory.createEntityManager();

        Cliente cliente = new Cliente(0,"Pedro");

        try{
            em.persist(cliente);
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
    }
}
