package br.com.arquivolivre.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface ConectorBanco {


    Statement novoStatement();
    
    PreparedStatement prepararStatement(String sql);
    
    boolean fecharConexao();
    
    boolean estaAberta();

}
