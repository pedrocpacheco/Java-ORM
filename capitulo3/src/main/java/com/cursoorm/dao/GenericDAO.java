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
        if(entidade == null)
            throw new RuntimeException("Entidade não encontrada");
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
    
    public void closeEntityManager(){
        if(em != null && em.isOpen())
            em.close();
    }

}

/*
 * O GenericDAO é uma Classe Pai que será herdada por outras classes DAO
 * Nela, organizamos e definimos operações basicas e comuns que apareceram em mais de uma classe DAO
 * 
 * 1- Na declaração da classe, precisamos colocar a generic <T, K> 
 *      - T significa Table
 *      - K significa Key
 *      Aqui, quando formos definir as subclasses, passamos suas configurações
 *      Exemplo: ClienteDAO precisa ter como T Cliente, e como K Integer (int)
 * 
 * 2- No Construtor do GenericDAO
 *      - É necessario criar o Entity Manager, seja por logica dentro do Construtor ou por argumento passado.
 *      - Definir o clazz do T. Isso quer dizer, pegar o caminho da classe utilizada no Generic T para usa-lo depois
 * 
 * 3- Criar metodos padrões para todos que irão implementar o GenericDAO
 *      - Não se preocupe em utilizar os blocos try-catch agora
 *      - No remove, faça uma logica para caso a chave de em nulo   
 *      - Utilize o clazz para os metodos buscar e listar que precisam da classe T
 * 
 * 4- Metodos para lidar com EntityManager
 *      - Crie um metodo commit contendo toda a logica do try-catch
 *      - Crie um metodo .close() 
 */