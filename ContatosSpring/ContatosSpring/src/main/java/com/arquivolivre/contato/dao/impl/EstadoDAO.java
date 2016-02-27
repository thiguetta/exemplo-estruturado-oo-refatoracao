package com.arquivolivre.contato.dao.impl;

import com.arquivolivre.contato.modelo.Estado;
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
        return session.createCriteria(Estado.class).list();
    }

}
