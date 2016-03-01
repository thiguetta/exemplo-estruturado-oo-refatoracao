package com.arquivolivre.contatos.controlador;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.arquivolivre.contatos.modelo.Produto;
import com.arquivolivre.contatos.servico.ProdutoService;

@Resource
@Path("/produto")
public class ProdutoController {

    private final ProdutoService service;
    private final Result result;

    public ProdutoController(ProdutoService service, Result result) {
        this.service = service;
        this.result = result;

    }

    @Path("/")
    public void index() {
    }

    @Path("/cadastro")
    public void cadastro(Produto produto) {
        service.cadastrarProduto(produto);
    }
}
