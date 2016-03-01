package com.arquivolivre.contatos.servico;

import br.com.caelum.vraptor.ioc.Component;
import com.arquivolivre.contatos.dao.ProdutoDao;
import com.arquivolivre.contatos.modelo.Produto;
import java.util.List;

@Component
public class ProdutoService {

    private final ProdutoDao dao;

    public ProdutoService(ProdutoDao dao) {
        this.dao = dao;
    }

    public List<Produto> listarProdutos() {
        return dao.listarTodos();
    }

    public Produto carregarProduto(long id) {
        return dao.carregar(id);
    }

    public void cadastrarProduto(Produto produto) {
        dao.cadastrar(produto);
    }

    public void atualizarProduto(Produto produto) {
        dao.atualizar(produto);
    }

    public void removerProduto(long id) {
        dao.remover(id);
    }
}
