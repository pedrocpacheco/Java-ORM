package com.cursoorm.dao;

import com.cursoorm.entity.Estabelecimento;

import jakarta.persistence.EntityManager;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer>{

    public EstabelecimentoDAO(EntityManager em) {
        super(em);
    }
  

}
