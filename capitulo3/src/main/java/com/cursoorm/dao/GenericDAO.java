package com.cursoorm.dao;
              // Table - Key

import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;

public class GenericDAO<T, K> {
    
    protected EntityManager em;

    private Class<T> clazz;

    public GenericDAO(EntityManager em){
        this.em = em;
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void cadastrar(T entidade){
       em.persist(entidade);
    }

    public void atualizar(T entidade){
        em.merge(entidade);
    }

    public T buscar(K chave){
        return em.find(clazz, chave);
    }

    public void remove(K chave){
        T entidade = buscar(chave);
        if(entidade == null){
            throw new RuntimeException("Entidade não encontrada");
        }
        em.remove(entidade);
    }

    public List<T> listar(){
        return em.createQuery("from " + clazz.getName()).getResultList();    
    }

    public void commit(){
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
    }

}
