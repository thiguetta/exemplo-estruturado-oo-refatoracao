package br.com.arquivolivre.contatos;

import br.com.arquivolivre.contatos.dao.PessoaDAO;
import br.com.arquivolivre.contatos.modelo.Pessoa;

public class Main {

    public static void main(String[] args) {
        PessoaDAO pessoaDao  = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoaDao.inserir(pessoa);
    }
}
