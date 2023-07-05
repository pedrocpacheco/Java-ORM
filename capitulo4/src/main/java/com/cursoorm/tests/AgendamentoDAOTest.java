package com.cursoorm.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.cursoorm.dao.AgendamentoDAO;
import com.cursoorm.entity.Agendamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AgendamentoDAOTest {
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormjpql");
        EntityManager em = factory.createEntityManager();

        AgendamentoDAO dao = new AgendamentoDAO(em);

        List<Agendamento> agendamentosData = dao.buscarPorData(new GregorianCalendar(2005, Calendar.JULY, 28));

        for (Agendamento agendamento : agendamentosData) {
            System.out.println(agendamento.getDataAgendamento().getTime());
            System.out.println(agendamento.getEspecialidade().getNome());
            System.out.println(agendamento.getPaciente().getNome());
        }

        factory.close();
        em.close();
    }
}
