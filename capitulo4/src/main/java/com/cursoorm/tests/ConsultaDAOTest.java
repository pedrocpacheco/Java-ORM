package com.cursoorm.tests;

import java.util.List;

import com.cursoorm.dao.ConsultaDAO;
import com.cursoorm.dao.EspecialidadeDAO;
import com.cursoorm.entity.Consulta;
import com.cursoorm.entity.Especialidade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConsultaDAOTest {
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormjpql");
        EntityManager em = factory.createEntityManager();

        ConsultaDAO dao = new ConsultaDAO(em);
        EspecialidadeDAO espDao = new EspecialidadeDAO(em);
        Especialidade esp = espDao.buscar(1);

        List<Consulta> lista = dao.buscarPorEspecialidade(esp);

        for (Consulta consulta : lista) {
            System.out.println(consulta.getEspecialidade().getNome());
            System.out.println(consulta.getDataConsulta().getTime());
            System.out.println(consulta.getPaciente().getNome()); 
        }

    }
}
