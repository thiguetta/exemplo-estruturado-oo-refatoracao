package com.arquivolivre.contato.dao.impl;

import com.arquivolivre.contato.dao.CRUD;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractCRUD<K, T>
        extends AbstractListDao<K, T>
        implements CRUD<K, T> {

    @Override
    public void inserir(K obj) {
        session.persist(obj);
    }

    @Override
    public void remover(K obj) {
        session.delete(obj);

    }

    @Override
    public void atualizar(K obj) {
        session.merge(obj);
    }
}
