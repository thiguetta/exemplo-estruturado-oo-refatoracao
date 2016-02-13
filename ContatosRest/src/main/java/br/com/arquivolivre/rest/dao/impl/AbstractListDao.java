package br.com.arquivolivre.rest.dao.impl;

import br.com.arquivolivre.rest.dao.ListDAO;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractListDao<K, T>
        implements ListDAO<K, T> {

    @Autowired
    protected EntityManager entityManager;
    private final Class<K> type;

    public AbstractListDao() {
        type = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public K buscaPorId(T id) {
        return entityManager.find(type, id);
    }
}
