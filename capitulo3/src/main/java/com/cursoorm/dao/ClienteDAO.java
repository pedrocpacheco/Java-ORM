package com.cursoorm.dao;

import jakarta.persistence.EntityManager;

public class ClienteDAO<Cliente, Integer> extends GenericDAO{

    public ClienteDAO(EntityManager em) {
        super(em);
    }
    
}
