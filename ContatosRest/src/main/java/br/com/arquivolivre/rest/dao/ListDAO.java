package br.com.arquivolivre.rest.dao;

import java.util.List;

public interface ListDAO<K, T> {

    List<K> listarTodos();

    K buscaPorId(T id);
}
