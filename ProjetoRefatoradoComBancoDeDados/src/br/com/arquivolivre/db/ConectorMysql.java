package br.com.arquivolivre.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorMysql implements ConectorBanco {

    private Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        }
    }

    public ConectorMysql(String base, String nomeUsuario, String senha) {
        try {
            String urlBanco = String.format("jdbc:mysql://localhost:3306/%s", base);
            connection = DriverManager.getConnection(urlBanco, nomeUsuario, senha);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel conectar ao banco de dados.");
        }
    }

    @Override
    public boolean fecharConexao() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Não foi possivel finalizar a conexao do banco");
            return false;
        }
        return true;
    }

    @Override
    public boolean estaAberta() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            return true;
        }
    }

    @Override
    public Statement novoStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Não foi possivel criar o Statement");
        }
        return null;
    }

    @Override
    public PreparedStatement prepararStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel criar o PreparedStatement");
        }
        return null;
    }

}
