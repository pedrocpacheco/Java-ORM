package com.cursoorm.dao;
              // Table - Key

import jakarta.persistence.EntityManager;

public class GenericDAO<T, K> {
    
    protected EntityManager em;

    public GenericDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(T entidade){
       em.persist(entidade);
    }

    public void atualizar(T entidade){
        em.merge(entidade);
    }

}
