package br.com.zup.controller;

import br.com.arquivolivre.contatos.dao.PessoaDAO;
import br.com.arquivolivre.contatos.db.ConectorBanco;
import br.com.arquivolivre.contatos.db.ConectorMysql;
import br.com.arquivolivre.contatos.modelo.Pessoa;
import java.util.List;

public class ContatosController {

    private final PessoaDAO contatoDAO;

    public ContatosController() {
        ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
        contatoDAO = new PessoaDAO(conector);
    }

    public List<Pessoa> listarTodos() {
        return contatoDAO.listarTodos();
    }

    public Pessoa getContato(String id) {
        if (id == null) {
            return Pessoa.novoContatoVazio();
        }
        return contatoDAO.buscarPorId(Integer.parseInt(id));
    }

    public void salvar(Pessoa contato) {
        if (contato.getId() == null) {
            contatoDAO.inserir(contato);
        } else {
            contatoDAO.atualizar(contato);
        }
    }

    public void remover(Pessoa contato) {
        contatoDAO.remover(contato);
    }
}
