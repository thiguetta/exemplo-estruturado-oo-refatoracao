package br.com.arquivolivre.contatos.dao.impl;

import br.com.arquivolivre.contatos.modelo.Estado;
import java.util.List;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class EstadoDAO extends AbstractListDao<Estado, Long> {

    @Override
    public List<Estado> listarTodos() {
        return entityManager.createNamedQuery("Estado.listarTodos").getResultList();
    }

}
