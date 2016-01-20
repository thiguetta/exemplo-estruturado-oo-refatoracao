package br.com.arquivolivre.contatos.dao.impl;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public abstract class AbstractCRUD<K, T> extends AbstractListDao<K, T> {

    public void inserir(K obj) {
        begin();
        entityManager.persist(obj);
        commit();
    }

    public void remover(K obj) {
        begin();
        entityManager.remove(obj);
        commit();

    }

    public void atualizar(K obj) {
        begin();
        entityManager.merge(obj);
        commit();
    }
}
