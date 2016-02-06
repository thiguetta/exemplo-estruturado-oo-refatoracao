package br.com.arquivolivre.rest.dao.impl;

import br.com.arquivolivre.rest.modelo.Pessoa;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Repository
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
