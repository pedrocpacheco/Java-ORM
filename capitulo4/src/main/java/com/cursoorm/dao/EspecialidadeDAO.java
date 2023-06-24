package com.cursoorm.dao;

import com.cursoorm.entity.Especialidade;

import jakarta.persistence.EntityManager;

public class EspecialidadeDAO extends GenericDAO<Especialidade, Integer>{

    public EspecialidadeDAO(EntityManager em) {
        super(em);
    }
    
}
