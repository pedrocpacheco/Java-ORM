package com.cursoorm.testesCrud;

import com.cursoorm.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CAtulizando {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cocapitulodois");
        EntityManager em = fabrica.createEntityManager();

        Cliente clienteBuscado = em.find(Cliente.class, 2);
        clienteBuscado.setNome("Filipe");

        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }

        Cliente novoMesmo = new Cliente(2, "Thiago");

        em.merge(novoMesmo);
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
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
 * 3- Atualizando o Objeto encontrado
 *      - Indo pelo caminho de primeiro encontrar o objeto, agora você pode
 *      atualizar uma informação desejada
 *      - Com isso, faça o bloco de Transaction comum, com o .begin() e o .commit()
 * 
 * 4- Criando objeto com ID existente
 *      - Caso você crie um outro objeto com o mesmo ID de algum outro que ja existe
 *      no banco, os passo mudam
 *      - Antes de utilizar o bloco Transaction comum, você precisa utilizar o .merge()
 *          - Passando como parametro o novo objeto
 */

