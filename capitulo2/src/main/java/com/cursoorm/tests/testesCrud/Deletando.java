package com.cursoorm.tests.testesCrud;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Deletando {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        Cliente clienteBuscado = em.find(Cliente.class, 2);

        em.remove(clienteBuscado);
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        em.close();
        fabrica.close();
    }
}

/*
 * 1- Criar Entity Manager
 *      - Crie uma EntityManagerFactory
 *      - Crie um EntityManager
 * 
 * 2- Encontrar um Objeto Especifico
 *      - Utilize o metodo find() do EntityManager instanciado
 *          - O primeiro parametro é o .class da Classe do Objeto
 *          - O segundo parametro é o ID do objeto especifico desejado
 * 
 * 3- Deletando o Objeto Especifico
 *      - Com o objeto encontrado, utilize o metodo em.remove()
 *          - Passando o objeto encontrado como parametro
 *      - Depois, faça o bloco Transaction Comum
 */
