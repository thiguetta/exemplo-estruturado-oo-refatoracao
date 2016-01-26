package br.com.arquivolivre.contatos.dao.impl;

import br.com.arquivolivre.contatos.dao.ListDAO;
import br.com.arquivolivre.contatos.singleton.EMF;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractListDao<K, T>
        implements ListDAO<K, T> {

    protected final EntityManager entityManager;
    private final Class<K> type;

    public AbstractListDao() {
        entityManager = EMF.getEntityManager();
        type = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public K buscaPorId(T id) {
        return entityManager.find(type, id);
    }

    protected void commit() {
        entityManager.getTransaction().commit();
    }

    protected void begin() {
        entityManager.getTransaction().begin();
    }
}
