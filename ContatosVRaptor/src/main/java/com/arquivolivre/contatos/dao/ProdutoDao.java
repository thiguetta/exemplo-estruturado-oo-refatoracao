package com.arquivolivre.contatos.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.arquivolivre.contatos.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;

@Component
public class ProdutoDao {

    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        em.persist(produto);
    }

    public void remover(long id) {
        Produto product = carregar(id);
        em.remove(product);
    }

    public void atualizar(Produto produto) {
        em.merge(produto);
    }
    
    public Produto carregar(long id){
        Produto product = em.find(Produto.class, id);
        return product;
    }
    
    public List<Produto> listarTodos(){
        return em.createNamedQuery("Produto.findAll").getResultList();
    }
}
