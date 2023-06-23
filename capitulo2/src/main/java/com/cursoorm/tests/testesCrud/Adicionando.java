package com.cursoorm.tests.testesCrud;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Adicionando {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        // Criando Objeto da Entidade
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Pedro");

        try{
            em.persist(cliente1);
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
 * 1- Criando Entity Manager paras nossas entidades
 *      - Precisamos EntityManagerFactory, que é uma Fabrica que criara as entitymanagers, passando o nome da nossa
 *        unidade de persistencia definida no pom.xml 
 *      - Com a fabrica criada, criamos o Entity Manager que desejamos.
 * 
 * 2- Salvando entidade no banco de dados
 *      - Precisamos criar primeiramente um Objeto da classe desejada em Java normal (Cliente nesse caso)
 *      - Depois, precisamos persistir esse objeto usando nosso Entity Manager
 * 
 * 3- Transação da Persistencia do Objeto
 *      - Para funcionar, precisamos ainda pegar a transação do Entity Manager, começar ela
 *      - Depois, precisamos commita-la, salvando o objeto criado no banco de dados
 *      - Caso uma exceção ocorra:
 *          - Precisamos verificar se a transção ainda esta aberta
 *          - Se estiver, precisamos dar o rollback nela
 */
