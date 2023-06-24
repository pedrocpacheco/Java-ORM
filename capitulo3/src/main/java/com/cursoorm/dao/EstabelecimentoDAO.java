package com.cursoorm.dao;

import com.cursoorm.entity.Estabelecimento;

import jakarta.persistence.EntityManager;

public class EstabelecimentoDAO {
    
    private EntityManager em;

    public void cadastrar(Estabelecimento est){
        try{
            em.getTransaction().begin();
            em.persist(est);
            em.getTransaction().commit();
       }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
       }
    }

}
