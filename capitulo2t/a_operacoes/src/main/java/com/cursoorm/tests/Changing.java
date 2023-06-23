package com.cursoorm.tests;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Changing {
   public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso_orm");
        EntityManager em = factory.createEntityManager();

        // Maneira 1 -> Mudando do ja existente
        Cliente mudandoExistente = em.find(Cliente.class, 1);
        mudandoExistente.setName("Thiago");

        try{
            em.persist(mudandoExistente);
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }finally{
            em.close();
            factory.close();
        }

        // Maneira 2 -> Criando um novo
        Cliente novoMesmoId = new Cliente(1, "Filipe");

        try{
            em.merge(novoMesmoId);
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
