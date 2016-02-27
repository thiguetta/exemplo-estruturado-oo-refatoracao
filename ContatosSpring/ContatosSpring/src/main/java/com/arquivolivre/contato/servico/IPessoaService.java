package com.arquivolivre.contato.servico;

import com.arquivolivre.contato.dao.impl.PessoaDAO;
import com.arquivolivre.contato.modelo.to.PessoaTO;

/**
 *
 * @author thiago
 */
public interface IPessoaService extends CrudService<PessoaDAO, PessoaTO> {

    void remover(Long id);
}
