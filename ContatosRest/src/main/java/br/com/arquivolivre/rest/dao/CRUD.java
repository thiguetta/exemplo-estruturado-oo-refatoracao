package br.com.arquivolivre.rest.dao;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public interface CRUD<K, T> extends ListDAO<K, T> {

    void inserir(K obj);

    void remover(K obj);

    void atualizar(K obj);
}
