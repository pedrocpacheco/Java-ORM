package com.cursoorm.dao;

import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDAO<AgendamentoDAO, Integer>{

    public AgendamentoDAO(EntityManager em) {
        super(em);
    }
    
}
