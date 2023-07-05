package com.cursoorm.tests;

import java.util.List;

import com.cursoorm.dao.PacienteDAO;
import com.cursoorm.entity.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PacienteDAOTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormjpql");
        EntityManager em = factory.createEntityManager();

        PacienteDAO dao = new PacienteDAO(em);

        // 1- Consulta Padrão
        List<Paciente> pacientes = dao.listar();
        pacientes.forEach(Paciente::toString);

        // 2- Consulta Ordenada por Nome
        List<Paciente> pacientesOrdenados = dao.listarPorNome(10, 2);
        pacientesOrdenados.stream().map(Paciente::getNome).forEach(System.out::println);

        // 3- Consulta com Where
        List<Paciente> pacientesWhere = dao.buscarPorNome("Pedro");
        pacientesWhere.forEach(p -> System.out.println(p.getNome()));

        em.close();
        factory.close();

    }
}
