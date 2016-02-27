package com.arquivolivre.contato.servico;

import com.arquivolivre.contato.dao.CRUD;

/**
 *
 * @author zupsjrp
 */
public interface CrudService<T extends CRUD, K> extends Service<T, K> {

    void inserir(K src);

    void atualizar(K src);

    void remover(K src);
}
