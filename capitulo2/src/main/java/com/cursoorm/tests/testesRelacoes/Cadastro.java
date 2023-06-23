package com.cursoorm.tests.testesRelacoes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.cursoorm.entities.Cliente;
import com.cursoorm.entities.ContratoAluguel;
import com.cursoorm.entities.Estabelecimento;
import com.cursoorm.entities.TipoEstabelecimento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Cadastro {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojaorm");
        EntityManager em = factory.createEntityManager();
        
        TipoEstabelecimento tipo = new TipoEstabelecimento(0, "Petshop", null);

        Cliente cliente1 = new Cliente(0, "Pedro", null);
        Cliente cliente2 = new Cliente(0, "Thiago", null);

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        ContratoAluguel contrato = new ContratoAluguel(0, 800, new GregorianCalendar(2005, Calendar.JULY, 28), null);

        Estabelecimento est1 = new Estabelecimento(0, "Fiap Pet", contrato, tipo, listaClientes);
        Estabelecimento est2 = new Estabelecimento(0, "Pacheco Pet", null, tipo, null);

        contrato.setEstabelecimento(est1);

        em.persist(est1);
        em.persist(est2);

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
    }
}
