package br.com.zup.controller;

import br.com.arquivolivre.contatos.dao.ContatoDAO;
import br.com.arquivolivre.contatos.db.ConectorBanco;
import br.com.arquivolivre.contatos.db.ConectorMysql;
import br.com.arquivolivre.contatos.modelo.Contato;
import java.util.List;

public class ContatosController {

    private final ContatoDAO contatoDAO;

    public ContatosController() {
        ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
        contatoDAO = new ContatoDAO(conector);
    }

    public List<Contato> listarTodos() {
        return contatoDAO.listarTodos();
    }

    public Contato getContato(String id) {
        if (id == null) {
            return Contato.novoContatoVazio();
        }
        return contatoDAO.buscarPorId(Integer.parseInt(id));
    }

    public void salvar(Contato contato) {
        if (contato.getId() == 0) {
            contatoDAO.inserir(contato);
        } else {
            contatoDAO.atualizar(contato);
        }
    }

    public void remover(Contato contato) {
        contatoDAO.remover(contato);
    }
}
