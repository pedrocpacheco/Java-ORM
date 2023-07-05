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
        return em.createQuery("from Consulta c where c.especialidade = :es", Consulta.class)
                .setParameter("es", esp)
                .getResultList();
    }

    public List<Consulta> buscarPorDatas(Calendar inicio, Calendar fim){
        return em.createQuery("from Consulta c where c.dataConsulta between :i and :f",Consulta.class)
                .setParameter("i", inicio)
                .setParameter("f", fim)
                .getResultList();
    }

    public List<Consulta> buscarPorNomePaciente(String nome){
        return em.createQuery("from Consulta c where c.paciente.nome like :n", Consulta.class)
                .setParameter("n", nome)
                .getResultList();
    }

}
