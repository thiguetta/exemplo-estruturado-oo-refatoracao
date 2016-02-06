package br.com.arquivolivre.rest.dao.impl;

import br.com.arquivolivre.rest.modelo.Estado;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Repository
public class EstadoDAO extends AbstractListDao<Estado, Long> {

    @Override
    public List<Estado> listarTodos() {
        return entityManager.createNamedQuery("Estado.listarTodos").getResultList();
    }

}
