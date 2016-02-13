package br.com.arquivolivre.rest.dao.impl;

import br.com.arquivolivre.rest.dao.CRUD;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractCRUD<K, T>
        extends AbstractListDao<K, T>
        implements CRUD<K, T> {

    @Override
    public void inserir(K obj) {
        entityManager.persist(obj);
    }

    @Override
    public void remover(K obj) {
        entityManager.remove(obj);

    }

    @Override
    public void atualizar(K obj) {
        entityManager.merge(obj);
    }
}
