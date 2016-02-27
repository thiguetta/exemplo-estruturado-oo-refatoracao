package com.arquivolivre.contato.servico;

import com.arquivolivre.contato.dao.ListDAO;
import java.util.List;

/**
 *
 * @author zupsjrp
 */
public interface Service<T extends ListDAO, K> {

    List<K> listarTodos();

    K buscarPorId(Long Id);
}
