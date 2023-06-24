package com.cursoorm.dao;

import com.cursoorm.entity.Consulta;

import jakarta.persistence.EntityManager;

public class ConsultaDAO extends GenericDAO<Consulta, Integer>{

    public ConsultaDAO(EntityManager em) {
        super(em);
    }
    
}
