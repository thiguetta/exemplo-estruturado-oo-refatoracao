package br.com.arquivolivre.rest.servico;

import br.com.arquivolivre.rest.dao.ListDAO;
import java.util.List;

/**
 *
 * @author zupsjrp
 */
public interface Service<T extends ListDAO, K> {

    List<K> listarTodos();

    K buscarPorId(Long Id);
}
