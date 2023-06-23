package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Deletando {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_orm");
        EntityManager em = factory.createEntityManager();

        Cliente encontrado = em.find(Cliente.class, 1);

        try{
            em.remove(encontrado);
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }finally{
            em.close();
            factory.close();
        }
    }
}
