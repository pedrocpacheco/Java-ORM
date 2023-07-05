package com.cursoorm.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;

public class GenericDAO<T, K> {

    // Protected -> Para as Filhas Utilizarem
    protected EntityManager em;
    
    // Protected -> Para as Filhas Utilizarem
    protected Class<T> classeEntidade;

    public GenericDAO(EntityManager em){
        this.em = em;
        classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void cadastrar(T entidade){
        em.persist(entidade);
    }

    public void atualizar(T entidade){
        em.merge(entidade);
    }

    public T buscar(K chave){
        return em.find(classeEntidade, chave);
    }

    public void remover(K chave){
        T entidadeExcluir = em.find(classeEntidade, chave);
        
        if(entidadeExcluir == null)
            throw new IllegalArgumentException("Nenhum registro de (" + this.classeEntidade.getSimpleName() + ")" + "encontrada com chave: (" + chave + ")");
        
        em.remove(entidadeExcluir);
    }
    
    public List<T> listar(){
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classeEntidade);
        CriteriaQuery<T> select = query.select(query.from(classeEntidade));

        return em.createQuery(select).getResultList();

        //ou: return em.createQuery("from " + clazz.getName()).getResultList(); 
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

    public void closeEntityManager(){
        if(em != null && em.isOpen())
            em.close();
    }        
}
