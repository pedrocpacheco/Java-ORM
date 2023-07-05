package com.cursoorm.dao;

import java.util.Calendar;
import java.util.List;

import com.cursoorm.entity.Consulta;
import com.cursoorm.entity.Especialidade;

import jakarta.persistence.EntityManager;

public class ConsultaDAO extends GenericDAO<Consulta, Integer>{

    public ConsultaDAO(EntityManager em) {
        super(em);
    }
    
    public List<Consulta> buscarPorEspecialidade(Especialidade esp){
        return em.createQuery("from Consulta where especialidade = :es", Consulta.class)
                .setParameter("es", esp)
                .getResultList();
    }

    public List<Consulta> buscarPorDatas(Calendar inicio, Calendar fim){
        return em.createQuery("from Consulta where dataConsulta between :i and :f",Consulta.class)
                .setParameter("i", inicio)
                .setParameter("f", fim)
                .getResultList();
    }

}
