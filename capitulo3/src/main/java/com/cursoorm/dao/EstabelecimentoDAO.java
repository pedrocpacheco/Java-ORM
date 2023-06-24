package com.cursoorm.dao;

import com.cursoorm.entity.Estabelecimento;

import jakarta.persistence.EntityManager;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer>{

    public EstabelecimentoDAO(EntityManager em) {
        super(em);
    }

}

/*
 * Extenda a classe GenericDAO
 *  - Crie o construtor parametrizado requerido
 *  
 * Utilizando os Generic:
 *  - Passe o tipo de classe (T) referente ao DAO desta classe em que estamos (EstabelecimentoDAO -> Estabelecimento)
 *  - Passe o tipo de chave (K) referente ao DAO desta classe em que estamos (int -> Integer)
 */
