package br.com.arquivolivre.rest.servico;

import br.com.arquivolivre.rest.dao.impl.PessoaDAO;
import br.com.arquivolivre.rest.modelo.to.PessoaTO;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public interface IPessoaService extends CrudService<PessoaDAO, PessoaTO> {

    void remover(Long id);
}
