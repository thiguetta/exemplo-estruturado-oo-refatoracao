package br.com.arquivolivre.dao;

import java.util.List;

public interface DAO<T> {

    List<T> findAll();

    List<T> findByName(String nome);

    T findById(int id);
    
    boolean save(T obj);
    
    boolean update(T obj);
    
    boolean delete(T obj);
}
