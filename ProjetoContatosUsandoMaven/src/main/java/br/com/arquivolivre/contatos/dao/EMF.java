package br.com.arquivolivre.contatos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class EMF {
    
    private final static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unidadePersistencia");
    private static EntityManager entityManager;
    
    public static EntityManager getEntityManager(){
        if(entityManager == null){
            entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        }
        return entityManager;
    }
}
