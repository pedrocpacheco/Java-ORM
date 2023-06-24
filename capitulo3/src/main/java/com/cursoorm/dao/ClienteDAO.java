package com.cursoorm.dao;

import com.cursoorm.entity.Cliente;

import jakarta.persistence.EntityManager;

public class ClienteDAO {
    
    private EntityManager em;

    public void cadastrar(Cliente cliente){
        try{
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
       }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
       }
    }

}
