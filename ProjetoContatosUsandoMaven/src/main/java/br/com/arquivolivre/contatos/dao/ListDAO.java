package br.com.arquivolivre.contatos.dao;

import java.util.List;

public interface ListDAO<K, T> {

    List<K> listarTodos();

    K buscaPorId(T id);
}
