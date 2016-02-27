package com.arquivolivre.contato.dao.impl;

import com.arquivolivre.contato.modelo.Pessoa;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Repository
public class PessoaDAO extends AbstractCRUD<Pessoa, Long> {

    public List<Pessoa> buscarPorNome(String nome) {
        return session.createCriteria(Pessoa.class)
                .add(Restrictions.like("nome", nome))
                .list();
    }

    @Override
    public List<Pessoa> listarTodos() {
        return session.createCriteria(Pessoa.class).list();
    }

}
