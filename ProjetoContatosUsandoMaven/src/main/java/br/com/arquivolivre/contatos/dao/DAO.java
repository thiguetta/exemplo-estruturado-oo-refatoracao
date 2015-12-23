package br.com.arquivolivre.contatos.dao;

import java.util.List;

public interface DAO<T> {

    List<T> listarTodos();

    List<T> buscarPorNome(String nome);

    T buscarPorId(Long id);

    void inserir(T obj);

    void atualizar(T obj);

    void remover(T obj);
}
