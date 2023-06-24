package com.cursoorm.dao;

import com.cursoorm.entity.Estabelecimento;

import jakarta.persistence.EntityManager;

public class EstabelecimentoDAO<Estabelecimento, Integer> extends GenericDAO{

    public EstabelecimentoDAO(EntityManager em) {
        super(em);
    }
  

}
