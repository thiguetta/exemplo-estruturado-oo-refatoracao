package br.com.arquivolivre.rest.servico;

import br.com.arquivolivre.rest.dao.impl.PessoaDAO;
import br.com.arquivolivre.rest.modelo.to.PessoaTO;

/**
 *
 * @author thiago
 */
public interface IPessoaService extends CrudService<PessoaDAO, PessoaTO> {

    void remover(Long id);
}
