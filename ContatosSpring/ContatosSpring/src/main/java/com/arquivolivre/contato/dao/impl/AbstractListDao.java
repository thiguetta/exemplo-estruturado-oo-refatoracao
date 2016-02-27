package com.arquivolivre.contato.dao.impl;

import com.arquivolivre.contato.dao.ListDAO;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractListDao<K, T>
        implements ListDAO<K, T> {

    @Autowired
    protected Session session;
    private final Class<K> type;

    public AbstractListDao() {
        type = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public K buscaPorId(T id) {
        return (K) session.createCriteria(type).add(Restrictions.eq("id", id)).uniqueResult();
    }
}
