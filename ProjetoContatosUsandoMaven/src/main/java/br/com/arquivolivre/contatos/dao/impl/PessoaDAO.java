package br.com.arquivolivre.contatos.dao.impl;

import br.com.arquivolivre.contatos.modelo.Pessoa;
import java.util.List;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class PessoaDAO extends AbstractCRUD<Pessoa, Long> {

    public List<Pessoa> buscarPorNome(String nome) {
        return entityManager
                .createNamedQuery("Pessoa.buscarPorNome")
                .setParameter("nome", nome)
                .getResultList();
    }

    @Override
    public List<Pessoa> listarTodos() {
        return entityManager
                .createNamedQuery("Pessoa.listarTodos")
                .getResultList();
    }

}
