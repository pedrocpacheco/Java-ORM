package com.cursoorm.dao;

import com.cursoorm.entity.Cliente;

import jakarta.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente, Integer>{

    public ClienteDAO(EntityManager em) {
        super(em);
    }
    
}

/*
 * Extenda a classe GenericDAO
 *  - Crie o construtor parametrizado requerido
 *  
 * Utilizando os Generic:
 *  - Passe o tipo de classe (T) referente ao DAO desta classe em que estamos (ClienteDAO -> Cliente)
 *  - Passe o tipo de chave (K) referente ao DAO desta classe em que estamos (int -> Integer)
 */
