package br.com.arquivolivre.contatos.db;

import java.sql.PreparedStatement;
import java.sql.Statement;

public interface ConectorBanco {

    Statement novoStatement();

    PreparedStatement prepararStatement(String sql);

    boolean fecharConexao();

    boolean estaAberta();

}
