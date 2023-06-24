package com.cursoorm.dao;

import com.cursoorm.entity.Cliente;

import jakarta.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente, Integer>{

    public ClienteDAO(EntityManager em) {
        super(em);
    }
    
}
