package br.com.arquivolivre.contatos.dao;

import br.com.arquivolivre.contatos.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;

public class PessoaDAO implements DAO<Pessoa> {

    private final EntityManager entityManager;

    public PessoaDAO() {
        this.entityManager = EMF.getEntityManager();
    }

    @Override
    public List<Pessoa> listarTodos() {
//        Session session = (Session) entityManager.getDelegate();
//        return session.createCriteria(Pessoa.class).list();
        return entityManager.createNamedQuery("Pessoa.findAll").getResultList();
    }

    @Override
    public List<Pessoa> buscarPorNome(String nome) {
//        Session session = (Session) entityManager.getDelegate();
//        return session
//                .createCriteria(Pessoa.class)
//                .add(Restrictions.like("nome", nome))
//                .list();
        return entityManager.createNamedQuery("Pessoa.findByName").setParameter("nome", nome).getResultList();
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public void inserir(Pessoa obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Pessoa obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remover(Pessoa obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

}
