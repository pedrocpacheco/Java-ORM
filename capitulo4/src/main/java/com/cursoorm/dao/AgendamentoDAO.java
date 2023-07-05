package com.cursoorm.dao;

import java.util.Calendar;
import java.util.List;

import com.cursoorm.entity.Agendamento;

import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDAO<AgendamentoDAO, Integer>{

    public AgendamentoDAO(EntityManager em) {
        super(em);
    }

    public int removerPorDataPrevista(Calendar data){
        em.getTransaction().begin();
        int total = em.createQuery("delete Agendamento a where a.dataConsultaPrevista = :d")
            .setParameter("d", data)
            .executeUpdate();
        em.getTransaction().commit();
        return total;
    }

    public int atualizarDataPrevista(Calendar origem, Calendar nova){ 
        em.getTransaction().begin();
        int total = em.createQuery("update Agendamento a set a.dataConsultaPrevista = :nova "
                    + "where a.dataConsultaPrevista = :origem")
                    .setParameter("origem", origem)
                    .setParameter("nova", nova)
                    .executeUpdate();
        em.getTransaction().commit();
        return total;

    }

    public List<Agendamento> buscarPorData(Calendar data){
        return em.createQuery("from Agendamento where dataAgendamento = :d",Agendamento.class) 
                .setParameter("d", data)
                .getResultList();
    }

}
