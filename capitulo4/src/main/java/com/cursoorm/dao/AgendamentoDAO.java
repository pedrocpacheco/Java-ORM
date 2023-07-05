package com.cursoorm.dao;

import java.util.Calendar;
import java.util.List;

import com.cursoorm.entity.Agendamento;

import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDAO<AgendamentoDAO, Integer>{

    public AgendamentoDAO(EntityManager em) {
        super(em);
    }

    public List<Agendamento> buscarPorData(Calendar data){
        return em.createQuery("from Agendamento where dataAgendamento = :d",Agendamento.class) 
                .setParameter("d", data)
                .getResultList();
    }

}
