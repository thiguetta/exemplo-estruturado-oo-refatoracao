package br.com.arquivolivre.contatos.servico;

import br.com.arquivolivre.contatos.dao.ListDAO;
import java.util.List;

/**
 *
 * @author zupsjrp
 */
public interface Service<T extends ListDAO, K> {

    List<K> listarTodos();

    K buscarPorId(Long Id);
}
