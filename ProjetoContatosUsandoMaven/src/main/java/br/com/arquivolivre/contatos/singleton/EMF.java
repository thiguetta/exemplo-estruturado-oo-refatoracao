package br.com.arquivolivre.contatos.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class EMF {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("unidadePersistencia");

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

}
