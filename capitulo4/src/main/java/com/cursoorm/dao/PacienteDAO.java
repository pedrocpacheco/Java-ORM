package com.cursoorm.dao;

import java.util.List;

import com.cursoorm.entity.Paciente;

import jakarta.persistence.EntityManager;

public class PacienteDAO extends GenericDAO<Paciente, Integer>{

    public PacienteDAO(EntityManager em) {
        super(em);
    }
    
    public List<Paciente> listarDoPaciente(){
        return em.createQuery("from Paciente", Paciente.class)
                    .getResultList();
    }

    public List<Paciente> listarPorNome(int inicio, int fim){      // Atributo = Nome | Tabela = nm_paciente
        return em.createQuery("from Paciente order by nome", Paciente.class)
                    .setFirstResult(inicio)
                    .setMaxResults(fim)
                    .getResultList();
    }

}

/*
 * Com o JPQL, podemos fazer consultas especificas utilizando um SQL similar ao JAVA 
 * 
 * 1- em.createQuery():
 *      - Usamos esse metodo do EntityManager para fazer uma consulta num banco de dados dele
 *      - O Primeiro Parametro é o texto da consulta (Utilize letra maiscula para classes)
 *      - O Segundo Parametro é o .class da classe que dejamos passar
 * 
 * 2- Ordenando por Nome:
 *      - Cria uma CreateQuery normal
 *      - Coloque o order by e o atributo
 * 
 * 3- Formatando a ordenação:
 *      - Se quiser descrecente -> coloque desc no final
 *      - Se quiser limitar, use o setMaxResult
 *      - Se quiser colocar uma janela de consultados:       
 *          - Crie uma variavel de inicio
 *              - Coloque seu valore na setFirstResult
 *          - Crie uma variavel de fim
 *              - Coloque seu valore na setMaxResult
 *              (o fim não é a possição do fim, e sim quantos a partir do inicio vao ter | inicio pode ser > que fim)
 * 
 * Preste atenção, que com o JPQL, não utilizamos o nome das tabelas, e sim das Classes/Atributos
 */