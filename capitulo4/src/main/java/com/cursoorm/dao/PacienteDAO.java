package com.cursoorm.dao;

import com.cursoorm.entity.Paciente;

import jakarta.persistence.EntityManager;

public class PacienteDAO extends GenericDAO<Paciente, Integer>{

    public PacienteDAO(EntityManager em) {
        super(em);
    }
    
}
