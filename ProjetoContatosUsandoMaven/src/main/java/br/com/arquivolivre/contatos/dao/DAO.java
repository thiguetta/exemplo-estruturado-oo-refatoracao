package br.com.arquivolivre.contatos.dao;

import java.util.List;

public interface DAO<T> {

    List<T> listarTodos();

    List<T> buscarPorNome(String nome);

    T buscarPorId(int id);

    boolean inserir(T obj);

    boolean atualizar(T obj);

    boolean remover(T obj);
}
