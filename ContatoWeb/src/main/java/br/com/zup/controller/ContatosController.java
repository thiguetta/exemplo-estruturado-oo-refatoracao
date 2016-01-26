package br.com.zup.controller;

import br.com.arquivolivre.contatos.dao.impl.PessoaDAO;
import br.com.arquivolivre.contatos.modelo.to.PessoaTO;
import br.com.arquivolivre.contatos.servico.PessoaService;
import java.util.List;

public class ContatosController {

    private final PessoaService pessoaService;

    public ContatosController() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaService = new PessoaService(pessoaDAO);
    }

    public List<PessoaTO> listarTodos() {
        return pessoaService.listarTodos();
    }

    public PessoaTO getContato(String id) {
        if (id == null) {
            return new PessoaTO();
        }
        return pessoaService.buscarPorId(Long.parseLong(id));
    }

    public void salvar(PessoaTO contato) {
        if (contato.getCodigo() == 0) {
            pessoaService.inserir(contato);
        } else {
            pessoaService.atualizar(contato);
        }
    }

    public void remover(Long id) {
        pessoaService.remover(id);
    }
}
